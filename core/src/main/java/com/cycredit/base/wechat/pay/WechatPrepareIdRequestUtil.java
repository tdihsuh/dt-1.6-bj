package com.cycredit.base.wechat.pay;

import com.cycredit.base.utils.IpUtils;
import com.cycredit.base.wechat.WechatConfig;
import com.cycredit.base.wechat.pay.pojo.PrepareOrder;
import com.cycredit.base.wechat.util.WechatHttpUtils;
import com.cycredit.base.wechat.util.WechatSignUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by qiyubin on 2017/5/17.
 */
public class WechatPrepareIdRequestUtil {

    private static final String PAY_TITLE = "黑名单详情支付";
    private static final String PAY_DETAIL = "失信主体详情";
    private static final String ATTACH = "保留参数";

    public static String perpareRequestXmlBody(HttpServletRequest request, String tradeNo, Long fee, String nonce_str) {
        //参数组

        String out_trade_no = tradeNo;
        //使用BigDecimal进行精确计算，否则float、double直接计算可能导致结果错误（比如计算4.015*100得到401.49999999999994，2-1.1得到0.8999999999999999），BigDecimal最好使用string初始化
        long total_fee = fee;


        String spbill_create_ip = IpUtils.getIp(request);     //客户端ip
        String time_start = timeStart();
        String time_expire = timeExpire();
        String appId = WechatConfig.appid;
        String mchId = WechatConfig.mch_id;
        String notify_url = WechatConfig.notify_url;
        String trade_type = "APP";

        //参数：开始生成签名 有序Map
        SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
        parameters.put("appid", appId);
        parameters.put("mch_id", mchId);
        parameters.put("nonce_str", nonce_str);
        parameters.put("body", PAY_TITLE);
        parameters.put("detail", PAY_DETAIL);
        parameters.put("attach", ATTACH);
        parameters.put("out_trade_no", out_trade_no);
        parameters.put("total_fee", total_fee);
        parameters.put("time_start", time_start);
        parameters.put("time_expire", time_expire);
        parameters.put("notify_url", notify_url);
        parameters.put("trade_type", trade_type);
        parameters.put("spbill_create_ip", spbill_create_ip);
        String sign = WechatSignUtils.createSign("UTF-8", parameters);


        PrepareOrder prepareOrder = new PrepareOrder();
        prepareOrder.setAppid(appId);
        prepareOrder.setMch_id(mchId);
        prepareOrder.setNonce_str(nonce_str);
        prepareOrder.setSign(sign);
        prepareOrder.setBody(PAY_TITLE);
        prepareOrder.setDetail(PAY_DETAIL);
        prepareOrder.setAttach(ATTACH);
        prepareOrder.setOut_trade_no(out_trade_no);
        prepareOrder.setTotal_fee(total_fee);
        prepareOrder.setSpbill_create_ip(spbill_create_ip);
        prepareOrder.setTime_start(time_start);
        prepareOrder.setTime_expire(time_expire);
        prepareOrder.setNotify_url(notify_url);
        prepareOrder.setTrade_type(trade_type);
        //构造xml参数
        String xmlInfo = WechatHttpUtils.prepareOrderXmlInfo(prepareOrder);

        return xmlInfo;
    }

    private static final String timeStyle = "yyyyMMddHHmmss";


    /*
     * 订单开始交易的时间
     */
    public static String timeStart() {
        return DateFormatUtils.format(new Date(), timeStyle);
    }


    /*
     * 订单开始交易的时间
     */
    public static String timeExpire() {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, 30);
        return DateFormatUtils.format(now.getTimeInMillis(), timeStyle);
    }


}
