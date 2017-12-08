package com.cycredit.app.controller.credit;

import com.cycredit.app.controller.credit.pojo.*;
import com.cycredit.app.controller.credit.pojo.detail.*;
import com.cycredit.base.utils.consts.Response;
import com.cycredit.common.Tag;
import com.cycredit.dao.entity.UniMemoDepartment;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
        PersonInfo personInfo = new PersonInfo("1", "张晓多", "110100198907180902", "北京市海淀区西土城路十号", "男");
        personDetail.setInfo(personInfo);

        List<CreditMemoEntry> memoEntryList = Lists.newArrayList();
        List<MemoDepartmentItem> testUnimemoDeps = Lists.newArrayList();
        testUnimemoDeps.add(new MemoDepartmentItem("犯法", "法律110条", "人民法院"));
        memoEntryList.add(new CreditMemoEntry(1L, "PUNISH", "企业联合执法", "法院", testUnimemoDeps, new Date()));

        List<MemoDepartmentItem> testBonusUnimemoDeps = Lists.newArrayList();
        testBonusUnimemoDeps.add(new MemoDepartmentItem("做好事", "好法110条", "人民法院"));
        memoEntryList.add(new CreditMemoEntry(2L, "BONUS", "奖励备忘录", "法院", testBonusUnimemoDeps, new Date()));

        personDetail.setCreditMemoList(memoEntryList);


        List<CreditDetailEntry> detailEntryList = Lists.newArrayList();
        detailEntryList.add(new CreditDetailEntry("法院", "认命法院"));
        personDetail.setCreditDetailList(detailEntryList);

        return Response.success("成功", personDetail);
    }


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
        List<PersonItem> personItems = Lists.newArrayList();
        PersonItem personItem = new PersonItem();
        personItem.setIdentityCard("110100198907180902");
        personItem.setPid("1");
        personItem.setName("张晓多");
        personItem.setTags("失信被执行人,奖励措施,违法嫌疑人");
        List<Tag> tagList = Lists.newArrayList();
        tagList.add(new Tag("失信被执行人", "PUNISH"));
        tagList.add(new Tag("奖励措施", "BONUS"));
        tagList.add(new Tag("违法嫌疑人", "PUNISH"));
        personItem.setTagList(tagList);
        personItems.add(personItem);
        return Response.success("成功", personItems);
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
        EnterpriseDetail enterpriseDetail = new EnterpriseDetail();
        EnterpriseInfo enterpriseInfo = new EnterpriseInfo("1", "913710007628687892", "辉山乳业有限责任公司", "张晓度", "有限责任公司（非自然人投资或控股的法人独资）", "北京市惠山路1号", "2029年05月17日", "2009年05月18日");
        enterpriseDetail.setInfo(enterpriseInfo);
        List<CreditMemoEntry> memoEntryList = Lists.newArrayList();

        List<MemoDepartmentItem> testUnimemoDeps = Lists.newArrayList();
        testUnimemoDeps.add(new MemoDepartmentItem("犯法", "法律110条", "人民法院"));
        memoEntryList.add(new CreditMemoEntry(1L, "PUNISH", "企业联合执法", "法院", testUnimemoDeps, new Date()));

        List<MemoDepartmentItem> testBonusUnimemoDeps = Lists.newArrayList();
        testBonusUnimemoDeps.add(new MemoDepartmentItem("做好事", "好法110条", "人民法院"));
        memoEntryList.add(new CreditMemoEntry(2L, "BONUS", "奖励备忘录", "法院", testBonusUnimemoDeps, new Date()));

        enterpriseDetail.setCreditMemoList(memoEntryList);


        List<CreditDetailEntry> detailEntryList = Lists.newArrayList();
        detailEntryList.add(new CreditDetailEntry("法院", "认命法院"));
        enterpriseDetail.setCreditDetailList(detailEntryList);


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
    public Object enterpriseSearch(String key) {
        List<EnterpriseItem> enterpriseItemList = Lists.newArrayList();
        EnterpriseItem enterpriseItem = new EnterpriseItem();
        enterpriseItem.setCode("913710007628687892");
        enterpriseItem.setEid("1");
        enterpriseItem.setName("辉山乳业有限责任公司");
        enterpriseItem.setTags("失信被执行人,奖励措施,违法嫌疑人");
        List<Tag> tagList = Lists.newArrayList();
        tagList.add(new Tag("失信被执行人", "PUNISH"));
        tagList.add(new Tag("奖励措施", "BONUS"));
        tagList.add(new Tag("违法嫌疑人", "PUNISH"));
        enterpriseItem.setTagList(tagList);
        enterpriseItemList.add(enterpriseItem);
        return Response.success("成功", enterpriseItemList);
    }


}
