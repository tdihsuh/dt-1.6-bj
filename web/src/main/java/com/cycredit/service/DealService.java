package com.cycredit.service;

import com.cycredit.app.util.threads.UserInfoThreadLocal;
import com.cycredit.dao.entity.EnterpriseDealResult;
import com.cycredit.dao.entity.PersonDealResult;
import com.cycredit.dao.entity.PersonDealResultExample;
import com.cycredit.dao.entity.User;
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

    public List<PersonDealResult> findMyEnterpriseDeal() {

        return null;
    }


    public void dealPerson(String dealType, String pid, String description) {
        PersonDealResult personDealResult = new PersonDealResult();
        personDealResult.setDealType(dealType);
        personDealResult.setPid(pid);
        personDealResult.setDescription(description);
        personDealResult.setUpdateTime(new Date());
        User user = UserInfoThreadLocal.getFromThread();
        personDealResult.setOperator(user.getId());
        personDealResult.setArea(user.getArea());
        personDealResult.setDepartment(user.getDepartment());
        personDealResultMapper.insertSelective(personDealResult);

    }

    public void dealEnterprise(String dealType, String pid, String description) {
        EnterpriseDealResult enterpriseDealResult = new EnterpriseDealResult();
        enterpriseDealResult.setDealType(dealType);
        enterpriseDealResult.setEid(pid);
        enterpriseDealResult.setDescription(description);
        enterpriseDealResult.setUpdateTime(new Date());
        User user = UserInfoThreadLocal.getFromThread();
        enterpriseDealResult.setOperator(user.getId());
        enterpriseDealResult.setArea(user.getArea());
        enterpriseDealResult.setDepartment(user.getDepartment());
        enterpriseDealResultMapper.insertSelective(enterpriseDealResult);
    }


}
