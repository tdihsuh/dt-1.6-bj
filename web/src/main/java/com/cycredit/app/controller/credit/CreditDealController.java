package com.cycredit.app.controller.credit;

import com.cycredit.app.util.threads.UserInfoThreadLocal;
import com.cycredit.base.utils.consts.Response;
import com.cycredit.dao.entity.EnterpriseDealResult;
import com.cycredit.dao.entity.PersonDealResult;
import com.cycredit.dao.entity.User;
import com.cycredit.service.DealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiyubin on 2017/11/20 0020.
 *
 * @author qiyubin
 */
@RestController
@RequestMapping(value = "/api/credit/operation")
@ResponseBody
@Api(value = "credit", description = "信用主体处理接口")
public class CreditDealController {

    @Resource
    DealService dealService;


    /**
     * 联合个人备忘录处理
     *
     * @param pid
     * @param dealType
     * @param description
     * @return
     */
    @RequestMapping(value = "/person", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "个人信用主体操作处理", httpMethod = "GET", value = "个人信用主体操作处理")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object personOperation(String pid, String dealType, String description) {
        PersonDealResult personDealResult = new PersonDealResult();
        personDealResult.setUpdateTime(new Date());
        personDealResult.setCreateTime(new Date());
        personDealResult.setDescription(description);
        personDealResult.setDealType(dealType);

        personDealResult.setPid(pid);
        User user = UserInfoThreadLocal.getFromThread();
        personDealResult.setDepartment(user.getDepartment());
        personDealResult.setArea(user.getArea());
        personDealResult.setOperator(user.getId());
        return Response.success("成功");
    }

    /**
     * 联合个人备忘录处理
     *
     * @param pid
     * @param dealType
     * @param description
     * @return
     */
    @RequestMapping(value = "/person/list", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "个人信用主体操作处理", httpMethod = "GET", value = "个人信用主体操作处理")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object personList(String pid, String dealType, String description) {
        User user = UserInfoThreadLocal.getFromThread();
        return dealService.findMyPersonDeal(user.getId());
    }


    /**
     * 联合企业备忘录处理
     *
     * @param pid
     * @param dealType
     * @param description
     * @return
     */
    @RequestMapping(value = "/enterprise", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "企业信用主体操作处理", httpMethod = "GET", value = "企业信用主体操作处理")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object enterpriseOperation(String pid, String dealType, String description) {
        EnterpriseDealResult enterpriseDealResult = new EnterpriseDealResult();
        enterpriseDealResult.setUpdateTime(new Date());
        enterpriseDealResult.setCreateTime(new Date());
        enterpriseDealResult.setDescription(description);
        enterpriseDealResult.setDealType(dealType);

        enterpriseDealResult.setEid(pid);
        User user = UserInfoThreadLocal.getFromThread();
        enterpriseDealResult.setDepartment(user.getDepartment());
        enterpriseDealResult.setArea(user.getArea());
        enterpriseDealResult.setOperator(user.getId());
        return Response.success("成功");
    }


    @RequestMapping(value = "/enterprise/list", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "企业信用主体操作处理", httpMethod = "GET", value = "企业信用主体操作处理")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object enterpriseList(String pid, String dealType, String description) {
        User user = UserInfoThreadLocal.getFromThread();
        return dealService.findMyEnterpriseDeal(user.getId());
    }


}
