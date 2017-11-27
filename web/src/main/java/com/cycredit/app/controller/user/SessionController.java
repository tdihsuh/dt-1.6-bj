package com.cycredit.app.controller.user;

import com.cycredit.app.util.authc.SecurityUtils;
import com.cycredit.base.utils.consts.Response;
import com.cycredit.dao.entity.User;
import com.cycredit.service.UserService;
import com.cycredit.service.UserTokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by qiyubin on 2017/11/21 0021.
 *
 * @author qiyubin
 */
@RestController
@RequestMapping(value = "user")
@ResponseBody
@Api(value = "user", description = "登录接口")
public class SessionController {


    @Resource
    UserService userService;

    @Resource
    UserTokenService userTokenService;

    @RequestMapping(value = "/session", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "session", httpMethod = "GET", value = "登录")
    public Object addCreditSelect(Long uid, String pwd, HttpServletResponse response) {

        User user = userService.findById(uid);

        Boolean checkResult = SecurityUtils.passwordCheck(user.getPassword(), pwd);

        if (checkResult) {
            SecurityUtils.loginSuccess(user.getName(), user.getId(), response);
            return Response.success("登录成功", SecurityUtils.fetchCurrentUserToken());

        } else {
            return Response.fail("登录失败");

        }
    }


    @RequestMapping(value = "/users", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "users", httpMethod = "POST", value = "新增用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    Object postUsers(User user) {
//        user.setPassword(SecurityTools.entryptPassword(user.getPassword()));
//        userService.save(user);
        return Response.success("注册用户成功");
    }


}




