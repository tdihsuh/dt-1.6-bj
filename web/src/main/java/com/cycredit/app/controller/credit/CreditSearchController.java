package com.cycredit.app.controller.credit;

import com.cycredit.app.controller.credit.pojo.*;
import com.cycredit.app.controller.credit.pojo.detail.*;
import com.cycredit.app.util.cache.pojo.UserInfo;
import com.cycredit.app.util.threads.UserInfoThreadLocal;
import com.cycredit.base.utils.consts.Response;
import com.cycredit.common.Tag;
import com.cycredit.dao.entity.UniMemoDepartment;
import com.cycredit.service.H3cService;
import com.cycredit.service.OriginService;
import com.cycredit.service.SearchCountService;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Key;
import java.util.Date;
import java.util.List;

/**
 * Created by qiyubin on 2017/11/20 0020.
 *
 * @author qiyubin
 */
@RestController
@RequestMapping(value = "/api/credit")
@ResponseBody
@Api(value = "credit", description = "信用主体搜索接口")
public class CreditSearchController {


    @Resource
    SearchCountService searchCountService;

    @Resource
    H3cService h3cService;

    private String mockPName = "洪祖文";
    private String mockPIdentity = "350582197707144512";
    private String mockPAddress = "河南";
    private String mockPGender = "男";
    private String mockPEventNum = "2017豫01民初2993号";

    /**
     * @return
     */
    @RequestMapping(value = "/personSearch", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "个人信用主体搜索", httpMethod = "GET", value = "个人信用主体搜索")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object personSearch(String key) {
        UserInfo thisUser = UserInfoThreadLocal.getFromThread();
        List<PersonItem> personItems = Lists.newArrayList();
//        PersonItem personItem = new PersonItem();
//        personItem.setPid("1");
//        personItem.setName(mockPName);
//        personItem.setIdentityCard(mockPIdentity);
//        personItem.setTagList(Lists.newArrayList(OriginService.tagMap.values()));


        PersonItem personItem = h3cService.getPersonItem(key, thisUser.getDepartmentCode());
        if (personItem != null)
            personItems.add(personItem);
        searchCountService.saveCount(SearchCountService.SearchType.person, UserInfoThreadLocal.getFromThread());

        return Response.success("成功", personItems);
    }

    /**
     * @param pid
     * @return
     */
    @RequestMapping(value = "/personDetail", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "个人信用主体信息详情", httpMethod = "GET", value = "个人信用主体信息详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object personDetail(String pid) {
//        PersonDetail personDetail = new PersonDetail();
//        PersonInfo personInfo = new PersonInfo("1", mockPName, mockPIdentity, mockPAddress, mockPGender);
//        personDetail.setInfo(personInfo);
//
//        List<CreditMemoEntry> memoEntryList = Lists.newArrayList();
//        List<MemoDepartmentItem> testUnimemoDeps = Lists.newArrayList();
//        testUnimemoDeps.add(new MemoDepartmentItem("犯法", "法律110条", "人民法院"));
//        memoEntryList.add(new CreditMemoEntry(1L, "PUNISH", "企业联合执法", "法院", testUnimemoDeps, new Date()));
//
//        List<MemoDepartmentItem> testBonusUnimemoDeps = Lists.newArrayList();
//        testBonusUnimemoDeps.add(new MemoDepartmentItem("做好事", "好法110条", "人民法院"));
//        memoEntryList.add(new CreditMemoEntry(2L, "BONUS", "奖励备忘录", "法院", testBonusUnimemoDeps, new Date()));
//
//        personDetail.setCreditMemoList(memoEntryList);
//
//        List<EventDetail> eventDetailList = Lists.newArrayList();
//        EventDetail e1 = new EventDetail();
//        e1.setEventName(mockPEventNum);
//        List<CreditDetailEntry> detailEntryList = Lists.newArrayList();
//        detailEntryList.add(new CreditDetailEntry("法院", "郑州市中级人民法院"));
//        detailEntryList.add(new CreditDetailEntry("执行依据文号", "2017豫01民初2993号"));
//        detailEntryList.add(new CreditDetailEntry("法律生效文书确定的义务：", "偿还欠款本金3500万元及利息"));
//        e1.setEventDetail(detailEntryList);
//        eventDetailList.add(e1);
//        personDetail.setCreditDetailList(eventDetailList);
        UserInfo thisUser = UserInfoThreadLocal.getFromThread();

        return Response.success("成功", h3cService.getPersonDetail(pid, thisUser.getDepartmentCode()));
    }


    private String mockEName = "周口裕华房地产开发有限公司";
    private String mockELeagal = "吕永广";
    private String mockECode = "91411600753860259R";
    private String mockEType = "有限责任公司(自然人投资或控股)";
    private String mockEAddress = "周口市八一路中段";
    private String mockEcreateTime = "2003-08-29";
    private String mockEvalidTime = "2015-08-15";


    /**
     * @return
     */
    @RequestMapping(value = "/enterpriseSearch", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "企业信用主体搜索", httpMethod = "GET", value = "企业信用主体搜索")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object enterpriseSearch(String key) {
        UserInfo thisUser = UserInfoThreadLocal.getFromThread();
        List<EnterpriseItem> enterpriseItemList = Lists.newArrayList();
//        EnterpriseItem enterpriseItem = new EnterpriseItem();
//        enterpriseItem.setEid("1");
//        enterpriseItem.setName(mockEName);
//        enterpriseItem.setCode(mockECode);
//
//        List<Tag> tagList = Lists.newArrayList();
//
//        enterpriseItem.setTagList(Lists.newArrayList(OriginService.tagMap.values()));

        EnterpriseItem enterpriseItem = h3cService.getEnterpriseItem(key, thisUser.getDepartmentCode());
        if (enterpriseItem != null)
            enterpriseItemList.add(enterpriseItem);
        searchCountService.saveCount(SearchCountService.SearchType.enterprise, UserInfoThreadLocal.getFromThread());

        return Response.success("成功", enterpriseItemList);
    }


    /**
     * @return
     */
    @RequestMapping(value = "/enterpriseDetail", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "企业信用主体详情", httpMethod = "GET", value = "企业信用主体详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object enterpriseDetail(String eid) {
//        EnterpriseDetail enterpriseDetail = new EnterpriseDetail();
//        EnterpriseInfo enterpriseInfo = new EnterpriseInfo("1", mockECode, mockEName, mockELeagal, mockEType, mockEAddress, mockEcreateTime, mockEvalidTime);
//        enterpriseDetail.setInfo(enterpriseInfo);
//        List<CreditMemoEntry> memoEntryList = Lists.newArrayList();
//
//        List<MemoDepartmentItem> testUnimemoDeps = Lists.newArrayList();
//        testUnimemoDeps.add(new MemoDepartmentItem("犯法", "法律110条", "人民法院"));
//        memoEntryList.add(new CreditMemoEntry("1", "PUNISH", "企业联合执法", "法院", testUnimemoDeps, new Date()));
//
//        List<MemoDepartmentItem> testBonusUnimemoDeps = Lists.newArrayList();
//        testBonusUnimemoDeps.add(new MemoDepartmentItem("做好事", "好法110条", "人民法院"));
//        memoEntryList.add(new CreditMemoEntry("2", "BONUS", "奖励备忘录", "法院", testBonusUnimemoDeps, new Date()));
//
//        enterpriseDetail.setCreditMemoList(memoEntryList);
//
//
//        List<EventDetail> eventDetailList = Lists.newArrayList();
//        EventDetail e1 = new EventDetail();
//        e1.setEventName("(2017)豫01执1072号");
//        List<CreditDetailEntry> detailEntryList = Lists.newArrayList();
//        detailEntryList.add(new CreditDetailEntry("执行法院：", "郑州市中级人民法院"));
//        detailEntryList.add(new CreditDetailEntry("法律生效文书确定的义务：", "偿还本息合计5017万元"));
//        e1.setEventDetail(detailEntryList);
//        eventDetailList.add(e1);
//        enterpriseDetail.setCreditDetailList(eventDetailList);

        UserInfo thisUser = UserInfoThreadLocal.getFromThread();
        return Response.success("成功", h3cService.getEnterpriseDetail(eid, thisUser.getDepartmentCode()));
    }

}
