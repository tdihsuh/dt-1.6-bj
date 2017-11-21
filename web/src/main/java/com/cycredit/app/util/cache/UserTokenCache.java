package com.cycredit.app.util.cache;

import com.alibaba.fastjson.JSONObject;
import com.cycredit.app.util.authc.UserToken;
import com.cycredit.base.utils.cache.JedisUtils;
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
        String json = JedisUtils.get(fetchCacheKey(uid));
        if (StringUtils.isNotEmpty(json)) {
            return JSONObject.parseObject(json, UserToken.class);
        }
        return null;
    }


    public static UserToken setUserTokenToCache(String uid, UserToken userToken) {

        JedisUtils.jedisOperate(jedis -> {
            jedis.set(fetchCacheKey(uid), JSONObject.toJSONString(userToken));
        });
        return null;
    }


}
