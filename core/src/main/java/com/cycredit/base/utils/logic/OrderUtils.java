package com.cycredit.base.utils.logic;

import com.cycredit.base.utils.cache.JedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import redis.clients.jedis.Jedis;

import java.util.Date;

/**
 * Created by qiyubin on 2017/5/3.
 */
public class OrderUtils {

    private static final String ORDER_PREFIX = "xinyong:blackcat:order:";

    public enum OrderType {
        //看人
        personSee("01"),
        //看企业
        enterpriseSee("02");
        private String code;

        public String getCode() {
            return code;
        }

        OrderType(String code) {
            this.code = code;
        }
    }

    public enum OrderStatus {
        //未付款
        unpaid,
        paid, //已付款

        canceled;   //订单取消
    }


    //还应该加入判断环境
    public static String getOrderNumByType(OrderType type) {
        String fullDay = getFullDay();
        String key = ORDER_PREFIX + type.name() + ":" + fullDay;
        String orderId = getOrderNum(key);
        String order = "01" + type.getCode() + fullDay + StringUtils.leftPad(orderId, 9, "0");
        return order;
    }


    private static String getOrderNum(String key) {
        Jedis jedis = null;
        try {
            jedis = JedisUtils.getResource();
            Long num = jedis.incr(key);
            return num.toString();

        } catch (Exception e) {

        } finally {
            JedisUtils.returnResource(jedis);
        }

        return null;
    }

    private static String getFullDay() {

        return DateFormatUtils.format(new Date(), "yyyyMMdd");
    }


}
