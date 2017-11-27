package com.cycredit.base.interceptors;

import com.cycredit.base.utils.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by qiyubin on 2017/6/27 0027.
 */
public class SwaggerApiAuthInterceptor extends HandlerInterceptorAdapter {


    private static final String BlackUrlKeyword = "swagger-ui.html";

    private static Logger logger = LoggerFactory.getLogger(SwaggerApiAuthInterceptor.class);

    public static ThreadLocal<Cookie[]> threadCookie = new ThreadLocal<>();


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();

        long oldTime = System.currentTimeMillis();

        if (path.contains(BlackUrlKeyword)) {
            Cookie cookie = RequestUtils.getCookie(request, SwaggerSecurityConfig.TOKEN_KEY);
            if (cookie == null) {
                response.setHeader("content-type", "text/html; charset=UTF-8");
                response.getWriter().write(SwaggerSecurityConfig.LOGIN_HTML);
                return false;
            } else {
                if (!cookie.getValue().equals(SwaggerSecurityConfig.RIGHT_TOKEN)) {
                    response.setHeader("content-type", "text/html; charset=UTF-8");
                    response.getWriter().write(SwaggerSecurityConfig.LOGIN_HTML);
                    return false;
                }
            }


        }
        threadCookie.set(request.getCookies());
        logger.info("Auth cost :" + (System.currentTimeMillis() - oldTime));

        return super.preHandle(request, response, handler);
    }


    private void loginSuccess(HttpServletResponse response, String token) {
        response.addCookie(new Cookie(SwaggerSecurityConfig.TOKEN_KEY, token));
    }


}
