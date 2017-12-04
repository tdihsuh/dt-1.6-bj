package com.cycredit.service;

import com.cycredit.app.util.threads.UserInfoThreadLocal;
import com.cycredit.dao.entity.*;
import com.cycredit.dao.mapper.EnterpriseDealResultMapper;
import com.cycredit.dao.mapper.PersonDealResultMapper;
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

    public List<PersonDealResult> findMyPersonDeal(Long uid) {
        PersonDealResultExample personDealResultExample = new PersonDealResultExample();
        personDealResultExample.createCriteria().andOperatorEqualTo(uid);
        return personDealResultMapper.selectByExample(personDealResultExample);
    }

    public List<EnterpriseDealResult> findMyEnterpriseDeal(Long uid) {
        EnterpriseDealResultExample enterpriseDealResultExample = new EnterpriseDealResultExample();
        enterpriseDealResultExample.createCriteria().andOperatorEqualTo(uid);
        return enterpriseDealResultMapper.selectByExample(enterpriseDealResultExample);
    }


    public void dealPerson(PersonDealResult personDealResult) {
        personDealResultMapper.insertSelective(personDealResult);

    }

    public void dealEnterprise(EnterpriseDealResult enterpriseDealResult) {
        enterpriseDealResultMapper.insertSelective(enterpriseDealResult);
    }


}
