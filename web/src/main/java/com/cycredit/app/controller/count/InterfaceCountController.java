package com.cycredit.app.controller.count;

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
    @RequestMapping("/personSearch")
    @ApiOperation(notes = "个人信用主体搜索统计", httpMethod = "GET", value = "个人信用主体搜索统计")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = true),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = true),
    })
    public String addPersonCount(String pid) {
        Map map = new HashMap();
        map.put("key", 123);
        map.put("value", "你好");
        return map.toString();
    }

    /**
     * 联合企业备忘录处理
     *
     * @param pid
     * @return
     */
    @RequestMapping("/enterpriseSearch")
    @ApiOperation(notes = "企业信用主体搜索统计", httpMethod = "GET", value = "企业信用主体搜索统计")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = true),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = true),
    })
    public String addEnterpriseCount(String pid, String dealType, String description) {

        Map map = new HashMap();
        map.put("key", 123);
        map.put("value", "你好");
        return map.toString();
    }

}
