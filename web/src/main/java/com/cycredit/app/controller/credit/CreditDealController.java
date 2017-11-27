package com.cycredit.app.controller.credit;

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
@Api(value = "credit", description = "信用主体处理接口")
public class CreditDealController {

    /**
     * 联合个人备忘录处理
     *
     * @param pid
     * @param dealType
     * @param description
     * @return
     */
    @RequestMapping("/personOperation")
    @ApiOperation(notes = "个人信用主体操作处理", httpMethod = "GET", value = "个人信用主体操作处理")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public String personOperation(String pid, String dealType, String description) {
        Map map = new HashMap();
        map.put("key", 123);
        map.put("value", "你好");
        return map.toString();
    }

    /**
     * 联合企业备忘录处理
     *
     * @param pid
     * @param dealType
     * @param description
     * @return
     */
    @RequestMapping("/enterpriseOperation")
    @ApiOperation(notes = "企业信用主体操作处理", httpMethod = "GET", value = "企业信用主体操作处理")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public String enterpriseOperation(String pid, String dealType, String description) {
        Map map = new HashMap();
        map.put("key", 123);
        map.put("value", "你好");
        return map.toString();
    }


}
