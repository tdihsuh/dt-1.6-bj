package com.cycredit.app.controller.credit;

import com.cycredit.app.controller.credit.pojo.deal.EnterpriseDealItem;
import com.cycredit.app.controller.credit.pojo.deal.PersonDealItem;
import com.cycredit.app.util.cache.pojo.UserInfo;
import com.cycredit.app.util.threads.UserInfoThreadLocal;
import com.cycredit.base.utils.consts.Response;
import com.cycredit.common.PageInfo;
import com.cycredit.dao.entity.EnterpriseDealResult;
import com.cycredit.dao.entity.PersonDealResult;
import com.cycredit.dao.entity.User;
import com.cycredit.service.DealService;
import com.google.common.collect.Lists;
import io.swagger.annotations.*;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
     * @return
     */
    @RequestMapping(value = "/download", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "报告下载", httpMethod = "POST", value = "下载")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object download(@ApiParam("0:个人 ,1:企业") @RequestParam String type, @ApiParam("报告Id") @RequestParam String id, HttpServletResponse response) {

        byte[] data = "hello".getBytes();


        response.setContentType("application/force-download");// 设置强制下载不打开
        response.addHeader("Content-Disposition",
                "attachment;fileName=1.txt");// 设置文件名

        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream;charset=UTF-8");
        OutputStream outputStream = null;
        try {
            outputStream = new BufferedOutputStream(response.getOutputStream());
            outputStream.write(data);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }


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
    @ApiOperation(notes = "个人信用主体操作处理", httpMethod = "POST", value = "个人信用主体操作处理")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object personOperation(@RequestParam(required = false, value = "pid") String pid, @ApiParam("0:'行政许可严格办理' 1:'行政许可加速审核'") @RequestParam(required = false, value = "dealType") String dealType, @RequestParam(required = false, value = "description") String description) {
        PersonDealResult personDealResult = new PersonDealResult();
        personDealResult.setUpdateTime(new Date());
        personDealResult.setCreateTime(new Date());
        personDealResult.setDescription(description);
        personDealResult.setDealType(dealType);
        //TODO 此处需要接口联调后 调取接口数据
        personDealResult.setIdentityCard("123");
        personDealResult.setName("张三");
        personDealResult.setTags("1,2,101");


        personDealResult.setPid(pid);
        UserInfo user = UserInfoThreadLocal.getFromThread();
        personDealResult.setOperatorDepartmentCode(user.getDepartmentCode());
        personDealResult.setOperatorAreaCode(user.getAreaCode());
        personDealResult.setOperator(user.getId());
        dealService.dealPerson(personDealResult);
        return Response.success("成功", personDealResult.getId());
    }

    /**
     * 联合企业备忘录处理
     *
     * @param dealType
     * @param description
     * @return
     */
    @RequestMapping(value = "/enterprise", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "企业信用主体操作处理", httpMethod = "POST", value = "企业信用主体操作处理")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object enterpriseOperation(HttpServletRequest request, @RequestParam(required = false, value = "eid") String eid, @ApiParam("0:'行政许可严格办理' 1:'行政许可加速审核'") @RequestParam(required = false, value = "dealType") String dealType, @RequestParam(required = false, value = "description") String description) {
        EnterpriseDealResult enterpriseDealResult = new EnterpriseDealResult();
        enterpriseDealResult.setUpdateTime(new Date());
        enterpriseDealResult.setCreateTime(new Date());

        //TODO 此处需要接口联调后 调取接口数据
        enterpriseDealResult.setCode("123");
        enterpriseDealResult.setName("测试企业");
        enterpriseDealResult.setTags("1,2,101");

        enterpriseDealResult.setDescription(description);
        enterpriseDealResult.setDealType(dealType);

        enterpriseDealResult.setEid(eid);
        UserInfo user = UserInfoThreadLocal.getFromThread();
        enterpriseDealResult.setOperatorDepartmentCode(user.getDepartmentCode());
        enterpriseDealResult.setOperatorAreaCode(user.getAreaCode());
        enterpriseDealResult.setOperator(user.getId());
        dealService.dealEnterprise(enterpriseDealResult);
        return Response.success("成功", enterpriseDealResult.getId());
    }

    /**
     * 联合个人备忘录处理
     *
     * @return
     */
    @RequestMapping(value = "/person/detail", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "个人信用主体处理记录详情", httpMethod = "GET", value = "个人信用主体处理记录详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object personDetail(Long id) {

        return Response.success("查询成功", dealService.findPersonDealDetail(id));
    }


    /**
     * 联合个人备忘录处理
     *
     * @return
     */
    @RequestMapping(value = "/enterprise/detail", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "企业主体处理记录详情", httpMethod = "GET", value = "企业主体处理记录详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object enterpriseDetail(Long id) {

        return Response.success("查询成功", dealService.findEnterpriseDealDetail(id));
    }


    /**
     * 联合个人备忘录处理
     *
     * @return
     */
    @RequestMapping(value = "/person/list", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "个人信用主体处理记录", httpMethod = "GET", value = "个人信用主体处理记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object personList(String name, String identityCard, Long startTime, Long endTime, Integer pageNum, Integer limitSize) {
        UserInfo user = UserInfoThreadLocal.getFromThread();
        PageInfo pageInfo = new PageInfo(pageNum, limitSize);
        Date startDate = startTime == null ? null : new Date(startTime);
        Date endDate = endTime == null ? null : new Date(endTime);
        List<PersonDealResult> list = null;
        //根据Role判断  高级Role查询地区下所有处理结果
        if (user.getRoleCode().equals("4")) {
            list = dealService.findMyPersonDeal(name, identityCard, startDate, endDate, user.getAreaCode(), pageInfo);
        } else {
            list = dealService.findMyPersonDeal(name, identityCard, startDate, endDate, user.getId()
                    , pageInfo);
        }

        List<PersonDealItem> responseList = Lists.transform(list, x -> PersonDealItem.convertToThis(x));


        return Response.success("查询成功", responseList).setPageInfo(pageInfo.getPageNo(), pageInfo.getTotalCount());
    }


    @RequestMapping(value = "/enterprise/list", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "企业信用主体处理记录", httpMethod = "GET", value = "企业信用主体处理记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object enterpriseList(String name, String code, Long startTime, Long endTime, Integer pageNum, Integer limitSize) {
        UserInfo user = UserInfoThreadLocal.getFromThread();
        PageInfo pageInfo = new PageInfo(pageNum, limitSize);
        Date startDate = startTime == null ? null : new Date(startTime);
        Date endDate = endTime == null ? null : new Date(endTime);
        List<EnterpriseDealResult> list;
        if (user.getRoleCode().equals("4")) {
            list = dealService.findMyEnterpriseDeal(name, code, startDate, endDate, user.getAreaCode(), pageInfo);

        } else {
            list = dealService.findMyEnterpriseDeal(name, code, startDate, endDate, user.getId(), pageInfo);
        }

        List<EnterpriseDealItem> responseList = Lists.transform(list, x -> EnterpriseDealItem.convertToThis(x));

        return Response.success("查询成功", responseList).setPageInfo(pageInfo.getPageNo(), pageInfo.getTotalCount());
    }


}
