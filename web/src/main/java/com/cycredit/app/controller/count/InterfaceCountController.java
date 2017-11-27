package com.cycredit.app.controller.count;

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
 * Created by qiyubin on 2017/11/9 0009.
 *
 * @author qiyubin
 */
@RestController
@RequestMapping(value = "/api/count")
@ResponseBody
@Api(value = "count", description = "统计接口")
public class InterfaceCountController {


    /**
     * 联合个人备忘录处理
     *
     * @param pid
     * @return
     */
    @RequestMapping(value = "/personSearch", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "个人信用主体搜索统计", httpMethod = "GET", value = "个人信用主体搜索统计")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token"),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid"),
    })
    public Object addPersonCount(String pid) {
        Map map = new HashMap();
        map.put("key", 123);
        map.put("value", "你好");
        return Response.success("成功");
    }

    /**
     * 联合企业备忘录处理
     *
     * @param pid
     * @return
     */
    @RequestMapping(value = "/enterpriseSearch", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "企业信用主体搜索统计", httpMethod = "GET", value = "企业信用主体搜索统计")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token"),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid"),
    })
    public Object addEnterpriseCount(String pid, String dealType, String description) {

        Map map = new HashMap();
        map.put("key", 123);
        map.put("value", "你好");
        return Response.success("成功");
    }

}
