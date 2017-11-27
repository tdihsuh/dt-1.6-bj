package com.cycredit.filter;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by qiyubin on 2015/12/2 0002.
 */
public class CrosFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS");
        response.addHeader("Access-Control-Expose-Headers", "jfid,xyid,code");


        Enumeration headerNames = request.getHeaderNames();
        List<String> headers = Lists.newArrayList();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            headers.add(key);
        }
        if (!headers.contains("content-type")) {
            headers.add("content-type");
        }
        if (!headers.contains("xyid")) {
            headers.add("xyid");
        }

        if (!headers.contains("jfid")) {
            headers.add("jfid");
        }

        response.addHeader("Access-Control-Allow-Headers", StringUtils.join(headers, ","));
        String origin = request.getHeader("origin");
        if (origin != null && origin.contains("xiaoyou.com")) {
            response.addHeader("Access-Control-Allow-Origin", origin);
        } else {
            response.addHeader("Access-Control-Allow-Origin", "*");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
