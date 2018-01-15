package com.cycredit.service;

import com.cycredit.common.PageInfo;
import com.cycredit.dao.entity.EnterpriseDealResult;
import com.cycredit.dao.entity.EnterpriseDealResultExample;
import com.cycredit.dao.entity.PersonDealResult;
import com.cycredit.dao.entity.PersonDealResultExample;
import com.cycredit.dao.mapper.EnterpriseDealResultMapper;
import com.cycredit.dao.mapper.PersonDealResultMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by qiyubin on 2017/12/1 0001.
 *
 * @author qiyubin
 */
@Service
public class DealService {

    @Resource
    PersonDealResultMapper personDealResultMapper;
    @Resource
    EnterpriseDealResultMapper enterpriseDealResultMapper;

    public PersonDealResult findPersonDealDetail(Long id) {
        return personDealResultMapper.selectByPrimaryKey(id);
    }


    private void completePersonCondition(String name, String code, Date startTime, Date endTime, PersonDealResultExample.Criteria criteria) {
        if (StringUtils.isNotEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (StringUtils.isNotEmpty(code)) {
            criteria.andIdentityCardLike("%" + code + "%");
        }
        if (startTime != null) {
            criteria.andCreateTimeGreaterThanOrEqualTo(startTime);
        }
        if (endTime != null) {
            criteria.andCreateTimeLessThanOrEqualTo(endTime);
        }
    }

    public List<PersonDealResult> findMyPersonDeal(String name, String code, Date startTime, Date endTime, String areaCode, String dpCode, PageInfo pageInfo) {

        PersonDealResultExample personDealResultExample = new PersonDealResultExample();
        PersonDealResultExample.Criteria criteria = personDealResultExample.createCriteria().andOperatorAreaCodeEqualTo(areaCode).andOperatorDepartmentCodeEqualTo(dpCode);
        completePersonCondition(name, code, startTime, endTime, criteria);

        pageInfo.setTotalCount(personDealResultMapper.countByExample(personDealResultExample));

        personDealResultExample.setOffset(pageInfo.getOffset());
        personDealResultExample.setLimit(pageInfo.getLimitSize());
        return personDealResultMapper.selectByExample(personDealResultExample);
    }


    public List<PersonDealResult> findMyPersonDeal(String name, String code, Date startTime, Date endTime, Long uid, PageInfo pageInfo) {

        PersonDealResultExample personDealResultExample = new PersonDealResultExample();
        PersonDealResultExample.Criteria criteria = personDealResultExample.createCriteria().andOperatorEqualTo(uid);
        completePersonCondition(name, code, startTime, endTime, criteria);

        pageInfo.setTotalCount(personDealResultMapper.countByExample(personDealResultExample));

        personDealResultExample.setOffset(pageInfo.getOffset());
        personDealResultExample.setLimit(pageInfo.getLimitSize());
        return personDealResultMapper.selectByExample(personDealResultExample);
    }

    public EnterpriseDealResult findEnterpriseDealDetail(Long id) {
        return enterpriseDealResultMapper.selectByPrimaryKey(id);
    }


    private void completeEnterpriseCondition(String name, String code, Date startTime, Date endTime, EnterpriseDealResultExample.Criteria criteria) {
        if (StringUtils.isNotEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (StringUtils.isNotEmpty(code)) {
            criteria.andCodeLike("%" + code + "%");
        }
        if (startTime != null) {
            criteria.andCreateTimeGreaterThanOrEqualTo(startTime);
        }
        if (endTime != null) {
            criteria.andCreateTimeLessThanOrEqualTo(endTime);
        }
    }

    public List<EnterpriseDealResult> findMyEnterpriseDeal(String name, String code, Date startTime, Date endTime, String areaCode, String dpCode, PageInfo pageInfo) {
        EnterpriseDealResultExample enterpriseDealResultExample = new EnterpriseDealResultExample();
        EnterpriseDealResultExample.Criteria criteria = enterpriseDealResultExample.createCriteria().andOperatorAreaCodeEqualTo(areaCode).andOperatorDepartmentCodeEqualTo(dpCode);
        completeEnterpriseCondition(name, code, startTime, endTime, criteria);

        pageInfo.setTotalCount(enterpriseDealResultMapper.countByExample(enterpriseDealResultExample));

        enterpriseDealResultExample.setLimit(pageInfo.getLimitSize());
        enterpriseDealResultExample.setOffset(pageInfo.getOffset());
        return enterpriseDealResultMapper.selectByExample(enterpriseDealResultExample);
    }

    public List<EnterpriseDealResult> findMyEnterpriseDeal(String name, String code, Date startTime, Date endTime, Long uid, PageInfo pageInfo) {
        EnterpriseDealResultExample enterpriseDealResultExample = new EnterpriseDealResultExample();
        EnterpriseDealResultExample.Criteria criteria = enterpriseDealResultExample.createCriteria().andOperatorEqualTo(uid);
        completeEnterpriseCondition(name, code, startTime, endTime, criteria);

        pageInfo.setTotalCount(enterpriseDealResultMapper.countByExample(enterpriseDealResultExample));

        enterpriseDealResultExample.setLimit(pageInfo.getLimitSize());
        enterpriseDealResultExample.setOffset(pageInfo.getOffset());
        return enterpriseDealResultMapper.selectByExample(enterpriseDealResultExample);
    }


    public void dealPerson(PersonDealResult personDealResult) {
        personDealResultMapper.insertSelective(personDealResult);

    }

    public void dealEnterprise(EnterpriseDealResult enterpriseDealResult) {
        enterpriseDealResultMapper.insertSelective(enterpriseDealResult);
    }


}
