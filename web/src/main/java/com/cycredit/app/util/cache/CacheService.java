package com.cycredit.app.util.cache;

import com.alibaba.fastjson.JSONObject;
import com.cycredit.app.util.authc.UserToken;
import com.cycredit.base.utils.cache.JedisUtils;
import com.cycredit.dao.entity.User;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by qiyubin on 2017/12/11 0011.
 *
 * @author qiyubin
 */
public class CacheService {

    public static <T> T getFromCache(String key, Class<T> c) {
        String json = JedisUtils.get(key);
        if (StringUtils.isNotEmpty(json)) {
            return JSONObject.parseObject(json, c);
        }
        return null;
    }


    public static <T> void setToCache(String key, T t) {

        JedisUtils.jedisOperate(jedis -> {
            jedis.set(key, JSONObject.toJSONString(t));
        });

    }

}
