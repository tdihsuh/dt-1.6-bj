package com.cycredit.app.controller;

import io.swagger.annotations.Api;
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
@RequestMapping(value = "user")
@ResponseBody
@Api(value = "user", description = "登录接口")
public class UserLoginController {


    @RequestMapping("/session")
    @ApiOperation(notes = "session", httpMethod = "GET", value = "登录")
    public String addCreditSelect(String uid, String pwd) {
        Map map = new HashMap();
        map.put("key", 123);
        map.put("value", "你好");
        return map.toString();
    }


}
