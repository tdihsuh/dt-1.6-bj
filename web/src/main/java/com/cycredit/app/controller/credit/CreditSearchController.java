package com.cycredit.app.controller.credit;

import com.cycredit.app.controller.credit.pojo.EnterpriseDetail;
import com.cycredit.app.controller.credit.pojo.EnterpriseItem;
import com.cycredit.app.controller.credit.pojo.PersonDetail;
import com.cycredit.app.controller.credit.pojo.PersonItem;
import com.cycredit.base.utils.consts.Response;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        PersonDetail personDetail = new PersonDetail();
        personDetail.setName("张晓多");
        personDetail.setAddress("北京市海淀区西土城路十号");
        personDetail.setIdentityCard("110100198907180902");
        personDetail.setPid("1");

        return Response.success("成功", personDetail);
    }


    /**
     * @param pid
     * @return
     */
    @RequestMapping(value = "/personSearch", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "个人信用主体搜索", httpMethod = "GET", value = "个人信用主体搜索")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object personSearch(String pid) {
        List<PersonItem> personItems = Lists.newArrayList();
        PersonItem personItem = new PersonItem();
        personItem.setIdentityCard("110100198907180902");
        personItem.setPid("1");
        personItem.setName("张晓多");
        personItem.setTags("失信被执行人,奖励措施,违法嫌疑人");
        return Response.success("成功", personItem);
    }


    /**
     * @param pid
     * @return
     */
    @RequestMapping(value = "/enterpriseDetail", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "企业信用主体详情", httpMethod = "GET", value = "企业信用主体详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object enterpriseDetail(String pid) {
        EnterpriseDetail enterpriseDetail = new EnterpriseDetail();
        enterpriseDetail.setPid("1");
        enterpriseDetail.setName("辉山乳业有限责任公司");
        enterpriseDetail.setCode("913710007628687892");
        enterpriseDetail.setAddress("北京市惠山路1号");
        enterpriseDetail.setType("有限责任公司（非自然人投资或控股的法人独资）");
        enterpriseDetail.setLegalPerson("张晓度");
        enterpriseDetail.setValidTime("2029年05月17日");
        enterpriseDetail.setCreateTime("2009年05月18日");

        return Response.success("成功", enterpriseDetail);
    }


    /**
     * @return
     */
    @RequestMapping(value = "/enterpriseSearch", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "企业信用主体搜索", httpMethod = "GET", value = "企业信用主体搜索")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object enterpriseSearch(String eid) {
        List<EnterpriseItem> enterpriseItemList = Lists.newArrayList();
        EnterpriseItem enterpriseItem = new EnterpriseItem();
        enterpriseItem.setCode("913710007628687892");
        enterpriseItem.setPid("1");
        enterpriseItem.setName("辉山乳业有限责任公司");
        enterpriseItem.setTags("失信被执行人,奖励措施");

        enterpriseItemList.add(enterpriseItem);
        return Response.success("成功", enterpriseItemList);
    }


}
