package com.cycredit.app.controller.user;

import com.cycredit.app.controller.user.pojo.SessionReponse;
import com.cycredit.app.util.authc.SecurityUtils;
import com.cycredit.app.util.threads.UserInfoThreadLocal;
import com.cycredit.base.utils.consts.Response;
import com.cycredit.dao.entity.User;
import com.cycredit.service.UserService;
import com.cycredit.service.UserTokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
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

    enum Role {
        infoCenterEmployee("信息中心职员"), infoCenterMajor("信息中心主任"),
        dpEmployee("部位职员"), dpMajor("部位主任");

        String name;

        Role(String name) {
            this.name = name;
        }
    }


    @RequestMapping(value = "/session", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "session", httpMethod = "POST", value = "登录")
    public Object addCreditSelect(@RequestPart(required = false) String uname, @RequestPart(required = false) String pwd, HttpServletResponse response) {

        try {
            User user = userService.findByName(uname);
            Boolean checkResult = SecurityUtils.passwordCheck(user.getPassword(), pwd);

            if (checkResult) {
                SecurityUtils.loginSuccess(user.getName(), user.getId(), user.getAreaCode(), user.getDepartmentCode(), response);

                //TODO 需要翻译
                return Response.success("登录成功", new SessionReponse(user.getId(), user.getName()
                        , user.getDepartmentCode(), "省环保厅", Role.infoCenterMajor.name(), Role.infoCenterMajor.name, user.getAreaCode(), "郑州市"));

            } else {
                return Response.fail("登录失败");

            }
        } catch (Exception e) {
            return Response.fail("登录失败");
        }
    }


    @RequestMapping(value = "/users", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "users", httpMethod = "GET", value = "查看用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    Object postUsers(User user) {
//        user.setPassword(SecurityTools.entryptPassword(user.getPassword()));
//        userService.save(user);

        return Response.success("查询成功", UserInfoThreadLocal.getFromThread());
    }


}




