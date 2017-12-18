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


    public List<PersonDealResult> findMyPersonDeal(String name, String code, Date startTime, Date endTime, Long uid, PageInfo pageInfo) {

        PersonDealResultExample personDealResultExample = new PersonDealResultExample();
        PersonDealResultExample.Criteria criteria = personDealResultExample.createCriteria().andOperatorEqualTo(uid);

        if (StringUtils.isNotEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (StringUtils.isNotEmpty(code)) {
            criteria.andIdentityCardLike("%" + code + "%");
        }
        if (startTime != null) {
            criteria.andCreateTimeGreaterThan(startTime);
        }
        if (endTime != null) {
            criteria.andCreateTimeLessThan(endTime);
        }


        pageInfo.setTotalCount(personDealResultMapper.countByExample(personDealResultExample));

        personDealResultExample.setOffset(pageInfo.getOffset());
        personDealResultExample.setLimit(pageInfo.getLimitSize());
        return personDealResultMapper.selectByExample(personDealResultExample);
    }

    public EnterpriseDealResult findEnterpriseDealDetail(Long id) {
        return enterpriseDealResultMapper.selectByPrimaryKey(id);
    }


    public List<EnterpriseDealResult> findMyEnterpriseDeal(String name, String code, Date startTime, Date endTime, Long uid, PageInfo pageInfo) {
        EnterpriseDealResultExample enterpriseDealResultExample = new EnterpriseDealResultExample();
        EnterpriseDealResultExample.Criteria criteria = enterpriseDealResultExample.createCriteria().andOperatorEqualTo(uid);

        if (StringUtils.isNotEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (StringUtils.isNotEmpty(code)) {
            criteria.andCodeLike("%" + code + "%");
        }
        if (startTime != null) {
            criteria.andCreateTimeGreaterThan(startTime);
        }
        if (endTime != null) {
            criteria.andCreateTimeLessThan(endTime);
        }

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
