package com.cycredit.app.util.cache;

import com.alibaba.fastjson.JSONObject;
import com.cycredit.app.util.authc.UserToken;
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

    public static User getFromCache(String uid) {
        String json = JedisUtils.get(fetchCacheKey(uid));
        if (StringUtils.isNotEmpty(json)) {
            return JSONObject.parseObject(json, User.class);
        }
        return null;
    }


    public static UserToken setToCache(String uid, User user) {

        JedisUtils.jedisOperate(jedis -> {
            jedis.set(fetchCacheKey(uid), JSONObject.toJSONString(user));
        });
        return null;
    }


}
