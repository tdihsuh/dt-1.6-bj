package com.cycredit.base.utils.consts;

import com.cycredit.base.utils.BasicStringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by qiyubin on 2017/7/5 0005.
 */
public class Servlets {

    private static String[] staticFiles = {".html", ".jpg", ".png"};

    public static HttpServletRequest getRequest() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isStaticFile(String uri) {
        if (staticFiles == null) {
            try {
                throw new Exception("检测到“app.properties”中没有配置“web.staticFile”属性。配置示例：\n#静态文件后缀\n"
                        + "web.staticFile=.css,.js,.png,.jpg,.gif,.jpeg,.bmp,.ico,.swf,.psd,.htc,.crx,.xpi,.exe,.ipa,.apk");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (BasicStringUtils.endsWithAny(uri, staticFiles) && !BasicStringUtils.endsWithAny(uri, ".jsp")
                && !BasicStringUtils.endsWithAny(uri, ".java")
            //&& !BasicStringUtils.endsWithAny(uri, urlSuffix)
                ) {
            return true;
        }
        return false;
    }

}
