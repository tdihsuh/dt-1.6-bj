package com.cycredit.base.wechat.util;


import com.cycredit.base.utils.MD5Utils;
import com.cycredit.base.wechat.WechatConfig;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;

/**
 * 微信支付签名
 */
public class WechatSignUtils {

    //http://mch.weixin.qq.com/wiki/doc/api/index.php?chapter=4_3
    //商户Key：改成公司申请的即可
    //32位密码设置地址http://www.sexauth.com/  jdex1hvufnm1sdcb0e81t36k0d0f15nc

    public static Map<Object, Object> sortMap(Map restmap) {
        List<String> keys = Lists.newArrayList(restmap.keySet());
        Collections.sort(keys,
                (x, y) -> {
                    return x.compareTo(y);
                }
        );
        Map<Object, Object> map = Maps.newLinkedHashMap();
        keys.forEach(x -> map.put(x, restmap.get(x)));
        return map;
    }


    /**
     * 微信支付签名算法sign
     *
     * @param characterEncoding
     * @param parameters
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static String createSign(String characterEncoding, Map<Object, Object> parameters) {
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();//所有参与传参的参数按照accsii排序（升序）
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v)
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + WechatConfig.key);
        String sign = MD5Utils.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
        return sign;
    }


}
