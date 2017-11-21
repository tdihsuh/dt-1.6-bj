package com.cycredit.app.inteceptors;

import com.alibaba.fastjson.JSONObject;
import com.cycredit.app.inteceptors.processor.ApiSecurityFilterProcessor;
import com.cycredit.app.util.authc.SecurityUtils;
import com.cycredit.base.utils.consts.Response;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by qiyubin on 2017/7/19 0019.
 */
public class ApiAuthInteceptors extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //url过滤规则 /com.cycredit.swagger/login
        String path = request.getServletPath();
        if (path.contains("login")) {
            return super.preHandle(request, response, handler);
        }


        Boolean isPass = ApiSecurityFilterProcessor.filterRequest(request);
        if (isPass) {
            return super.preHandle(request, response, handler);
        } else {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JSONObject.toJSONString(Response.fail("token过期", null, "1001")));
            return false;
        }
    }

}
