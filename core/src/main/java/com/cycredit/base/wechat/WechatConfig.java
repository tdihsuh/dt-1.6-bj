package com.cycredit.base.wechat;

import com.cycredit.base.properties.AppConfig;
import com.cycredit.base.utils.SpringContextHolder;

/**
 * Created by qiyubin on 2017/7/3 0003.
 */
public class WechatConfig {

    public final static String key = "IOBNv8Yz3ZxfbpypMVoN7IT4IvCatelC";

    public final static AppConfig appConfig = SpringContextHolder.getBean("appConfig");
    public final static String appid = appConfig.getProperties().getProperty("wechat.appid");
    public final static String mch_id = appConfig.getProperties().getProperty("wechat.mch_id");
    public final static String notify_url = appConfig.getProperties().getProperty("wechat.notify.url");


}
