package com.cycredit.app.controller.user;

import com.cycredit.app.util.authc.SecurityUtils;
import com.cycredit.app.util.cache.pojo.UserInfo;
import com.cycredit.app.util.threads.UserInfoThreadLocal;
import com.cycredit.base.utils.SecurityTools;
import com.cycredit.base.utils.consts.Response;
import com.cycredit.dao.entity.User;
import com.cycredit.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by qiyubin on 2018/1/5 0005.
 *
 * @author qiyubin
 */
@RestController
@RequestMapping(value = "/api/user")
@ResponseBody
@Api(value = "密码服务", description = "修改密码接口")
public class PasswordController {

    @Resource
    UserService userService;


    @RequestMapping(value = "/password", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "users", httpMethod = "PUT", value = "修改密码")
    Object postUsers(String newPwd, String oldPwd) {
        UserInfo userInfo = UserInfoThreadLocal.getFromThread();
        User user = userService.findById(userInfo.getId());
        if (SecurityUtils.passwordCheck(user.getPassword(), oldPwd)) {
            User updateUser = new User();
            updateUser.setId(userInfo.getId());
            updateUser.setPassword(SecurityTools.entryptPassword(newPwd));
            userService.save(updateUser);
        } else {
            return Response.success("修改密码失败");
        }
        //        user.setPassword();
//        userService.save(user);

        return Response.success("修改密码成功");
    }


}
