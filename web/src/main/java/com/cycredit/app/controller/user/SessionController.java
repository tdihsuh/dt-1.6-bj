package com.cycredit.app.controller.user;

import com.cycredit.app.controller.user.pojo.SessionReponse;
import com.cycredit.app.util.authc.SecurityUtils;
import com.cycredit.app.util.cache.pojo.UserInfo;
import com.cycredit.app.util.threads.UserInfoThreadLocal;
import com.cycredit.base.utils.consts.Response;
import com.cycredit.dao.entity.User;
import com.cycredit.service.OriginService;
import com.cycredit.service.UserService;
import com.cycredit.service.UserTokenService;
import com.cycredit.service.enums.Role;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import net.bytebuddy.asm.Advice;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    OriginService originService;
    @Resource
    UserTokenService userTokenService;


    @RequestMapping(value = "/session", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "session", httpMethod = "POST", value = "登录")
    public Object addCreditSelect(@RequestParam(required = false, value = "uname") String uname, @RequestParam(required = false, value = "pwd") String pwd,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {

        try {
            User user = userService.findByName(uname);
            Boolean checkResult = SecurityUtils.passwordCheck(user.getPassword(), pwd);

            if (checkResult) {

                UserInfo cacheUser = new UserInfo();
                cacheUser.setId(user.getId());
                cacheUser.setAreaCode(user.getAreaCode());
                cacheUser.setDepartmentCode(user.getDepartmentCode());
                cacheUser.setName(user.getName());
                cacheUser.setRoleCode(user.getRoleCode());
                try {
                    cacheUser.setRoleName(Role.getRoleByCode(user.getRoleCode()).getName());
                } catch (Exception e) {
                    return Response.fail("用户角色非法");
                }
                try {
                    cacheUser.setDepartmentName(originService.getDepartment(user.getDepartmentCode()).getDepartmentName());
                } catch (Exception e) {
                    return Response.fail("用户部门非法");
                }
                try {
                    cacheUser.setAreaName(originService.getAreaByCode(user.getAreaCode()).getAreaName());
                } catch (Exception e) {
                    return Response.fail("用户地区非法");
                }


                SecurityUtils.loginSuccess(cacheUser, response);

                //TODO 需要翻译
                return Response.success("登录成功", new SessionReponse(cacheUser.getId(), cacheUser.getName()
                        , cacheUser.getDepartmentCode(), cacheUser.getDepartmentName(), cacheUser.getRoleCode().toString(), cacheUser.getRoleName(), cacheUser.getAreaCode(), cacheUser.getAreaName()));

            } else {
                return Response.fail("登录失败");

            }
        } catch (Exception e) {
            e.printStackTrace();
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




