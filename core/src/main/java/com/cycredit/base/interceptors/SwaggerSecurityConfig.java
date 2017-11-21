package com.cycredit.base.interceptors;

import com.cycredit.base.utils.MD5Utils;

/**
 * Created by qiyubin on 2017/8/10 0010.
 */
public class SwaggerSecurityConfig {
    public static final String USERNAME = "admin";
    public static final String PASSWORD = "admin";

    public static final String TOKEN_KEY = "simpleToken";
    public static final String RIGHT_TOKEN = MD5Utils.getMD5(USERNAME + ":" + PASSWORD);
    public static final String LOGIN_HTML = "<head>\n" +
            "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
            "</head>\n" +
            "<body>\n" +
            "<form action=\"/simple-security.do\">\n" +
            "<div style=\"width:400px;height:300px;border:1px solid;\">\n" +
            "<table style=\"\">\n" +
            "\n" +
            "<tr><td>\n" +
            "<input type=\"text\" name=\"userName\"/>\n" +
            "</tr>\n" +
            "\n" +
            "<tr><td>\n" +
            "<input type=\"text\" name=\"password\"/>\n" +
            "</tr>\n" +
            "\n" +
            "<tr><td>\n" +
            "<input type=\"submit\" value=\"登录\"/>\n" +
            "</tr>\n" +
            "\n" +
            "</table>\n" +
            "</div>\n" +
            "</form>\n" +
            "</body>";
}
