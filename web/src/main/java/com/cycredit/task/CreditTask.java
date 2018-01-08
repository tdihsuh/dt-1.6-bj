package com.cycredit.task;

import com.alibaba.fastjson.JSONObject;
import com.cycredit.dao.entity.*;
import com.cycredit.dao.manual.UnimemoDepartmentManualMapper;
import com.cycredit.dao.mapper.*;
import com.cycredit.service.OriginService;
import com.cycredit.service.entity.DepartmentMemoId;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.naming.directory.SearchResult;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by qiyubin on 2017/12/13 0013.
 * "0 0 12 * * ?" 每天中午12点触发
 * "0 15 10 ? * *" 每天上午10:15触发
 * "0 15 10 * * ?" 每天上午10:15触发
 * "0 15 10 * * ? *" 每天上午10:15触发
 * "0 15 10 * * ? 2005" 2005年的每天上午10:15触发
 * "0 * 14 * * ?" 在每天下午2点到下午2:59期间的每1分钟触发
 * "0 0/5 14 * * ?" 在每天下午2点到下午2:55期间的每5分钟触发
 * "0 0/5 14,18 * * ?" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
 * "0 0-5 14 * * ?" 在每天下午2点到下午2:05期间的每1分钟触发
 * "0 10,44 14 ? 3 WED" 每年三月的星期三的下午2:10和2:44触发
 * "0 15 10 ? * MON-FRI" 周一至周五的上午10:15触发
 * "0 15 10 15 * ?" 每月15日上午10:15触发
 * "0 15 10 L * ?" 每月最后一日的上午10:15触发
 * "0 15 10 ? * 6L" 每月的最后一个星期五上午10:15触发
 * "0 15 10 ? * 6L 2002-2005" 2002年至2005年的每月的最后一个星期五上午10:15触发
 * "0 15 10 ? * 6#3" 每月的第三个星期五上午10:15触发
 *
 * @author qiyubin
 */
@Component
public class CreditTask {
    @Resource
    OriginService originService;

    @Resource
    AreaMapper areaMapper;
    @Resource
    AreaRankMapper areaRankMapper;
    @Resource
    DepartmentMapper departmentMapper;

    @Resource
    UniMemoDepartmentMapper uniMemoDepartmentMapper;

    @Resource
    UnimemoDepartmentManualMapper unimemoDepartmentManualMapper;
    @Resource
    DepartmentRankMapper departmentRankMapper;

    @Resource
    EnterpriseDealResultMapper enterpriseDealResultMapper;
    @Resource
    PersonDealResultMapper personDealResultMapper;
    @Resource
    SearchCountMapper searchCountMapper;


    private static Logger logger = LoggerFactory.getLogger(CreditTask.class);

    final Map<String, Department> departmentMap = Maps.newHashMap();
    final Map<String, Area> areaMap = Maps.newHashMap();

    @PostConstruct
    public void init() {
        AreaExample areaExample = new AreaExample();
        List<Area> areas = areaMapper.selectByExample(areaExample);
        for (Area area : areas) {
            areaMap.put(area.getAreaCode(), area);
        }
        DepartmentExample departmentExample = new DepartmentExample();
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        for (Department department : departments) {
            departmentMap.put(department.getDepartmentCode(), department);
        }
//        refreshDepartRank();
//        refreshAreaRank();
        //auto repair rank

    }

    private int fetchPunishCount(String code) {
        EnterpriseDealResultExample enterpriseDealResultExample = new EnterpriseDealResultExample();
        enterpriseDealResultExample.createCriteria().andOperatorDepartmentCodeEqualTo(code).andCreditTypeEqualTo("0");
        long ec = enterpriseDealResultMapper.countByExample(enterpriseDealResultExample);
        PersonDealResultExample personDealResultExample = new PersonDealResultExample();
        personDealResultExample.createCriteria().andOperatorDepartmentCodeEqualTo(code).andCreditTypeEqualTo("0");
        long pc = personDealResultMapper.countByExample(personDealResultExample);
        return (int) (ec + pc);
    }

    private int fetchBonusCount() {
        return 0;
    }

    private int fetchSelectCount(String dpCode) {
        SearchCountExample searchCountExample = new SearchCountExample();
        searchCountExample.createCriteria().andDepartmentCodeEqualTo(dpCode);
        long count = searchCountMapper.countByExample(searchCountExample);
        return (int) count;
    }


    public void refreshDepartRank() {
        unimemoDepartmentManualMapper.clearDepartmentRank();
        //calc

        List<DepartmentMemoId> list = unimemoDepartmentManualMapper.selectDepartmentMemoIds();

        Integer totoalCount = 0;
        Integer selectCount = 0;
        Integer creditCount = 0;

        List<DepartmentRank> departmentRanks = Lists.newArrayList();
        for (DepartmentMemoId departmentMemoId : list) {
            String tempCode = departmentMemoId.getDepartmentCode();
            String tempMemoIds = departmentMemoId.getMemoIds();
            DepartmentRank tempRank = unimemoDepartmentManualMapper.selectDepartmenRanktByDpCode(tempCode);
            // join count
            //<editor-fold>
            {
                Integer joinCount = 0;
                if (StringUtils.isNotEmpty(tempMemoIds)) {
                    for (String tempMemoId : tempMemoIds.split(",")) {
                        for (DepartmentMemoId compareDp : list) {
                            if (compareDp.getDepartmentCode().equals(tempCode)) {
                                continue;
                            }
                            if (StringUtils.isNotEmpty(compareDp.getMemoIds())) {
                                for (String compareDpMemoId : compareDp.getMemoIds().split(",")) {
                                    if (compareDpMemoId.equals(tempMemoId))
                                        joinCount++;
                                }
                            } else {
                                continue;
                            }
                        }

                    }
                }
                //部门联合部委数
                tempRank.setJoinCount(joinCount);
                totoalCount += joinCount;
            }
            //</editor-fold>

            //部门联合惩戒数
            int tempPunishCount = fetchPunishCount(tempCode);
            tempRank.setUniPunishCount(tempPunishCount);
            //部门联合激励数
            int tempBonusCount = fetchBonusCount();
            tempRank.setUniBonusCount(tempBonusCount);
            tempRank.setUniCount(tempBonusCount + tempBonusCount);
            creditCount += (tempPunishCount + tempBonusCount);

            //部门查询次数
            int tempSelectCount = fetchSelectCount(tempCode);
            tempRank.setSelectCount(tempSelectCount);
            selectCount += tempSelectCount;
            departmentRankMapper.updateByPrimaryKeySelective(tempRank);
            departmentRanks.add(tempRank);
        }

        List<DepartmentRank> allRank = departmentRankMapper.selectByExample(new DepartmentRankExample());
        outer:
        for (DepartmentRank departmentRank : allRank) {
            for (DepartmentRank existRank : departmentRanks) {
                if (existRank.getDepartmentCode().equals(departmentRank.getDepartmentCode())) {
                    continue outer;
                }
            }
            departmentRanks.add(departmentRank);
        }


        for (DepartmentRank temp : departmentRanks) {
            //z1 1000*该部委备忘录数量/数量最多次数
            int z1 = 1000 * temp.getJoinCount() / totoalCount;
            //z2 1000*该部委查询次数/最高查询次数
            int z2 = 1000 * temp.getSelectCount() / selectCount;
            //z3 1000*该部委联合奖惩次数/数量最高次
            int z3 = 1000 * (temp.getUniPunishCount() + temp.getUniBonusCount()) / creditCount;
            // Z=0.2*	Z1+0.3*Z2+0.5*Z3
            double z = z1 * 0.2 + z2 * 0.3 + z3 * 0.5;
            temp.setActiveCount((int) z);
            departmentRankMapper.updateByPrimaryKeySelective(temp);

        }


        Collections.sort(departmentRanks, (o2, o1) -> o1.getActiveCount() - o2.getActiveCount());
        int rank = 1;
        for (DepartmentRank departmentRank : departmentRanks) {
            departmentRank.setRank(rank);
            rank++;
            departmentRankMapper.updateByPrimaryKeySelective(departmentRank);

        }

    }


    private int fetchAreaPunishCount(String code) {
        EnterpriseDealResultExample enterpriseDealResultExample = new EnterpriseDealResultExample();
        enterpriseDealResultExample.createCriteria().andOperatorAreaCodeEqualTo(code).andCreditTypeEqualTo("0");
        long ec = enterpriseDealResultMapper.countByExample(enterpriseDealResultExample);
        PersonDealResultExample personDealResultExample = new PersonDealResultExample();
        personDealResultExample.createCriteria().andOperatorAreaCodeEqualTo(code).andCreditTypeEqualTo("0");
        long pc = personDealResultMapper.countByExample(personDealResultExample);
        return (int) (ec + pc);
    }

    private int fetchAreaBonusCount() {
        return 0;
    }

    private int fetchAreaSelectCount(String areaCode) {
        SearchCountExample searchCountExample = new SearchCountExample();
        searchCountExample.createCriteria().andAreaCodeEqualTo(areaCode);
        long count = searchCountMapper.countByExample(searchCountExample);
        return (int) count;
    }


    public void refreshAreaRank() {
        unimemoDepartmentManualMapper.clearAreaRank();

        List<AreaRank> areaRanks = areaRankMapper.selectByExample(new AreaRankExample());

        int creditCount = 0;
        int selectCount = 0;

        for (AreaRank areaRank : areaRanks) {
            int punishCount = fetchAreaPunishCount(areaRank.getAreaCode());
            areaRank.setUniPunishCount(punishCount);
            int bonusCount = fetchAreaBonusCount();
            areaRank.setUniBonusCount(bonusCount);
            areaRank.setUniCount(punishCount + bonusCount);

            int tempSelectCount = fetchAreaSelectCount(areaRank.getAreaCode());
            areaRank.setSelectCount(tempSelectCount);

            creditCount += (bonusCount + punishCount);
            selectCount += tempSelectCount;
            areaRankMapper.updateByPrimaryKeySelective(areaRank);

        }

        for (AreaRank temp : areaRanks) {
            //Y1=1000*该城市查询次数/最高查询次数
            int y1 = 1000 * temp.getSelectCount() / selectCount;
            //Y2=1000*该城市联合奖惩次数/数量最高次
            int y2 = 1000 * (temp.getUniBonusCount() + temp.getUniPunishCount()) / creditCount;

            //Y=0.6*	Y1+0.4*Y2
            double y = y1 * 0.6 + y2 * 0.4;
            temp.setActiveCount((int) y);
            areaRankMapper.updateByPrimaryKeySelective(temp);
        }

        Collections.sort(areaRanks, (o2, o1) -> o1.getActiveCount() - o2.getActiveCount());
        int rank = 1;
        for (AreaRank areaRank : areaRanks) {
            areaRank.setRank(rank);
            rank++;
            areaRankMapper.updateByPrimaryKeySelective(areaRank);

        }

    }


    @Scheduled(cron = "0 0/30 *  * * ? ")   //每5分钟执行一次
    // 每隔1秒隔行一次
    public void run() {
        logger.info("刷新部门地区活跃");
        refreshAreaRank();
        refreshDepartRank();

    }


}
