package com.cycredit.base.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by TonyMeng on 2017/4/25.
 */
public class IpUtils {
    public static List<String> solrBucketList(List<String> list) {//对list按照list.get(x).getDocCount()降序排列，用于处理搜索聚类
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String b1, String b2) {
                return b1.compareTo(b2);
            }
        });
        return list;
    }

    /**
     * 获取远程访问客户端IP
     */
    public static String getRemoteIp() {
        //当在Controller中调用该方法时，RequestContextHolder已经被自动注入绑定到了调用者的线程上，因此可以直接获取到
        return IpUtils.getIp(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());//传入Request 返回IP
    }

    public static String getIp(HttpServletRequest request) {//从Request中获取客户端真实IP

        String remoteIp = request.getHeader("x-forwarded-for");
        if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
            remoteIp = request.getHeader("X-Real-IP");
        }
        if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
            remoteIp = request.getHeader("Proxy-Client-IP");
        }
        if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
            remoteIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
            remoteIp = request.getHeader("HTTP_CLIENT_IP");
        }
        if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
            remoteIp = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
            remoteIp = request.getRemoteAddr();
        }
        if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
            remoteIp = request.getRemoteHost();
        }
        return remoteIp;
    }

    public static String getRemoteHost(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ?"127.0.0.1":ip;
    }
    public static int getValidNum(int num, int min, int max) {//获取在有效范围的数字
        if (num < min) {
            num = min;
        } else if (num > max) {
            num = max;
        }
        return num;
    }



}


