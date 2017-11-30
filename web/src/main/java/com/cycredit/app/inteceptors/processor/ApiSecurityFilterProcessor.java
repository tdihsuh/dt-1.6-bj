package com.cycredit.app.inteceptors.processor;

import com.cycredit.app.util.authc.UserToken;
import com.cycredit.app.util.cache.UserInfoCache;
import com.cycredit.app.util.cache.UserTokenCache;
import com.cycredit.app.util.threads.UserInfoThreadLocal;
import com.cycredit.app.util.threads.UserTokenThreadLocal;
import com.cycredit.base.interceptors.SwaggerApiAuthInterceptor;
import com.cycredit.base.utils.CookiesUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by qiyubin on 2017/7/19 0019.
 */
public class ApiSecurityFilterProcessor {


    /**
     * 拦截请求当请求中的Uid和Token能够匹配时，将会话写入线程中
     *
     * @param request
     * @return
     */
    public static Boolean filterRequest(HttpServletRequest request) {
        String userToken = request.getHeader("token");
        String uid = request.getHeader("uid");
        if (uid == null) {
            uid = CookiesUtils.getCookieValue(SwaggerApiAuthInterceptor.threadCookie.get(), "uid", false);
        }
        if (userToken == null) {
            userToken = CookiesUtils.getCookieValue(SwaggerApiAuthInterceptor.threadCookie.get(), "token", false);
        }


        if (StringUtils.isNotEmpty(uid)) {
            return validUserToken(uid, userToken);
        }
        return false;
    }

    public static Boolean validUserToken(String headerUid, String headerToken) {
        UserToken userToken = UserTokenCache.getUserToeknFromCache(headerUid);
        if (userToken != null) {
            if (userToken.getToken().equals(headerToken)) {
                //check and push data to thread
                UserTokenThreadLocal.putIntoThread(userToken);
                UserInfoThreadLocal.putIntoThread(UserInfoCache.getFromCache(headerUid));

                return true;
            }
        }
        return false;

    }


}
