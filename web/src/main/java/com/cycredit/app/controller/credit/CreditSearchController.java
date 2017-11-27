package com.cycredit.app.controller.credit;

import com.cycredit.base.utils.consts.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
    ApiImplicitParam[] value() {
        return new ApiImplicitParam[]{


        };
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
        Map map = new HashMap();
        map.put("key", 123);
        map.put("value", "你好");
        return Response.success("成功");
    }


    /**
     * @param pid
     * @param dealType
     * @param description
     * @return
     */
    @RequestMapping(value = "/personSearch", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "个人信用主体搜索", httpMethod = "GET", value = "个人信用主体搜索")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object personSearch(String pid, String dealType, String description) {
        Map map = new HashMap();
        map.put("key", 123);
        map.put("value", "你好");
        return Response.success("成功");
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
        Map map = new HashMap();
        map.put("key", 123);
        map.put("value", "你好");
        return Response.success("成功");
    }


    /**
     * @param pid
     * @param dealType
     * @param description
     * @return
     */
    @RequestMapping(value = "/enterpriseSearch", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "企业信用主体搜索", httpMethod = "GET", value = "企业信用主体搜索")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object enterpriseSearch(String pid, String dealType, String description) {
        Map map = new HashMap();
        map.put("key", 123);
        map.put("value", "你好");
        return Response.success("成功");
    }


}
