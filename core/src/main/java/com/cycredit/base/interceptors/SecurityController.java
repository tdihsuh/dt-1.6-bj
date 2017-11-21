package com.cycredit.base.interceptors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by qiyubin on 2017/6/27 0027.
 */
@Controller
@RequestMapping(value = "")
public class SecurityController {


    private void loginSuccess(HttpServletResponse response, String token) {
        response.addCookie(new Cookie(SwaggerSecurityConfig.TOKEN_KEY, token));
    }

    @RequestMapping(value = "/simple-security", produces = "application/json;charset=UTF-8")
    @ResponseBody
    Object simple(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String userNameParam = request.getParameter("userName");
        String passwordParam = request.getParameter("password");
        if (SwaggerSecurityConfig.USERNAME.equals(userNameParam) && SwaggerSecurityConfig.PASSWORD.equals(passwordParam)) {
            loginSuccess(response, SwaggerSecurityConfig.RIGHT_TOKEN);
            response.setHeader("content-type", "text/html; charset=UTF-8");
            response.getWriter().write("<script>alert('登录成功')</script>");

        } else {
            response.getWriter().write(SwaggerSecurityConfig.LOGIN_HTML);
            response.getWriter().write("<script>alert('账户密码错误')</script>");
            return false;
        }
        response.sendRedirect(request.getContextPath() + "/swagger-ui.html");
        return true;
    }
}
