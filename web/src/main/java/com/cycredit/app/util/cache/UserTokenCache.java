package com.cycredit.app.util.cache;

import com.alibaba.fastjson.JSONObject;
import com.cycredit.app.util.authc.UserToken;
import com.cycredit.base.utils.cache.JedisUtils;
import com.cycredit.dao.entity.User;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by qiyubin on 2017/7/19 0019.
 */
public class UserTokenCache {

    private static String TOKEN_CACHE = "user:token:cache";

    private static String fetchCacheKey(String uid) {

        return new StringBuffer(TOKEN_CACHE).append(":").append(uid).toString();
    }

    public static UserToken getUserToeknFromCache(String uid) {
        return CacheService.getFromCache(fetchCacheKey(uid), UserToken.class);

    }


    public static void setUserTokenToCache(String uid, UserToken userToken) {
        CacheService.setToCache(fetchCacheKey(uid), userToken);
    }


}
