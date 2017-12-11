package com.cycredit.app.util.authc;

import com.cycredit.app.util.cache.UserInfoCache;
import com.cycredit.app.util.cache.UserTokenCache;
import com.cycredit.app.util.cache.pojo.UserInfo;
import com.cycredit.app.util.threads.UserTokenThreadLocal;
import com.cycredit.base.utils.Encodes;
import com.cycredit.dao.entity.User;
import com.cycredit.service.OriginService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

/**
 * 登录后数据藏在redis中
 * Created by qiyubin on 2017/7/11 0011.
 */
public class SecurityUtils {

    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;


    public static UserToken fetchCurrentUserToken() {
        return UserTokenThreadLocal.getFromThread();
    }


    public static Boolean passwordCheck(String dbPwd, String pwd) {
        byte[] salt = Encodes.decodeHex(dbPwd.substring(0, 16));
        ByteSource saltSource = ByteSource.Util.bytes(salt);
        String hashedCredentials = dbPwd.substring(16);

        SimpleHash simpleHash = new SimpleHash(HASH_ALGORITHM, pwd, salt, HASH_INTERATIONS);
        return simpleHash.toString().equals(hashedCredentials);
    }

    //token -> user

    public static void loginSuccess(UserInfo userInfo, HttpServletResponse response) {

        //add user token cache
        String token = UUID.randomUUID().toString();
        UserToken userToken = new UserToken();
        userToken.setUsername(userInfo.getName());
        userToken.setUid(userInfo.getId());
        userToken.setToken(token);
        userToken.setCreateTime(new Date());
        UserTokenCache.setUserTokenToCache(userInfo.getId().toString(), userToken);
//        UserTokenThreadLocal.putIntoThread(userToken);

        //add userinfo cache

        //TODO add 用户权限
        UserInfoCache.setToCache(userInfo.getId().toString(), userInfo);


        //write cookie to api path
        Cookie cookie1 = new Cookie("uid", userInfo.getId().toString());
        cookie1.setPath("/");
        response.addCookie(cookie1);
        Cookie cookie2 = new Cookie("token", token);
        cookie2.setPath("/");
        response.addCookie(cookie2);


    }


}
