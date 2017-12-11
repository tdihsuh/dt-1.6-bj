package com.cycredit.app.util.cache;

import com.alibaba.fastjson.JSONObject;
import com.cycredit.app.util.authc.UserToken;
import com.cycredit.app.util.cache.pojo.UserInfo;
import com.cycredit.base.utils.cache.JedisUtils;
import com.cycredit.dao.entity.User;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by qiyubin on 2017/11/29 0029.
 *
 * @author qiyubin
 */
public class UserInfoCache {

    private static String INFO_CACHE = "user:info:cache";

    private static String fetchCacheKey(String uid) {

        return new StringBuffer(INFO_CACHE).append(":").append(uid).toString();
    }

    public static UserInfo getFromCache(String uid) {
        return CacheService.getFromCache(fetchCacheKey(uid), UserInfo.class);
    }


    public static void setToCache(String uid, UserInfo user) {
        CacheService.setToCache(fetchCacheKey(uid), user);
    }


}
