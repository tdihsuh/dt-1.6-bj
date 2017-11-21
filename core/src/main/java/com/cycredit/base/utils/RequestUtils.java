package com.cycredit.base.utils;

import org.junit.Ignore;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by qiyubin on 2017/6/27 0027.
 */
@Ignore
public class RequestUtils {

    public static Cookie getCookie(HttpServletRequest request, String name) {
        if (request.getCookies() == null) {
            return null;
        }
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(name)) {
                return cookie;
            }
        }
        return null;
    }

}
