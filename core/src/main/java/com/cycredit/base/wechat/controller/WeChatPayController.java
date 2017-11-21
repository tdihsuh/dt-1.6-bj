package com.cycredit.base.wechat.controller;

import com.alibaba.fastjson.JSONObject;
import com.cycredit.base.utils.logic.OrderUtils;
import com.cycredit.base.wechat.WechatConfig;
import com.cycredit.base.wechat.pay.WechatPrepareIdRequestUtil;
import com.cycredit.base.wechat.util.WechatHttpUtils;
import com.cycredit.base.wechat.util.WechatSignUtils;
import com.cycredit.base.wechat.util.WechatXmlParseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by TonyMeng on 2017/4/25.
 */
@Controller
@RequestMapping("/app/pay")
public class WeChatPayController {

    private static Logger logger = LoggerFactory.getLogger(WeChatPayController.class);


    @ResponseBody
    @RequestMapping("/wechatpay")
    public Object wechatPay(@RequestParam(required = true) String buyId, HttpServletRequest request) {
        if (buyId == null) {
            return null;
        }
        String creditNo = null;

        String orderNum = OrderUtils.getOrderNumByType(OrderUtils.OrderType.personSee);
        String appid = WechatConfig.appid;
        String mch_id = WechatConfig.mch_id;
        String nonce_str = getRandomString(16);
        String payPrepareXml = WechatPrepareIdRequestUtil.perpareRequestXmlBody(request, orderNum, 1L, nonce_str);
        String wxUrl = "https://com.cycredit.swagger.mch.weixin.qq.com/pay/unifiedorder";
        String method = "POST";
        String weixinPostResult = WechatHttpUtils.httpsRequest(wxUrl, method, payPrepareXml).toString();
        try {
            Map<String, String> restmap = WechatXmlParseUtils.jdomParseXmlToMap(weixinPostResult);

            String prepayId_t = restmap.get("prepay_id");
            String noce_str_t = restmap.get("nonce_str");
            String timeStamp_t = String.valueOf(System.currentTimeMillis() / 1000);
            String package_t = "Sign=WXPay";
            //createOrder

//            orderService.createOrder(sysMobileUser.getId(), 1l, orderNum, prepayId_t, buyId, creditNo, title);


            SortedMap<Object, Object> newParameters = new TreeMap<Object, Object>();
            newParameters.put("appid", appid);
            newParameters.put("partnerid", mch_id);
            newParameters.put("prepayid", prepayId_t);
            newParameters.put("package", package_t);
            newParameters.put("noncestr", noce_str_t);
            newParameters.put("timestamp", timeStamp_t);
            String newSign = WechatSignUtils.createSign("UTF-8", newParameters);


            JSONObject payPrepareRet = WechatXmlParseUtils.jdomParseXmlToJson(weixinPostResult);
            payPrepareRet.put("sign2", newSign);
            payPrepareRet.put("timestamp", timeStamp_t);
            payPrepareRet.put("partnerid", mch_id);
            payPrepareRet.put("packagevalue", package_t);
            payPrepareRet.put("ordernum", orderNum);
            payPrepareRet.put("callBack", WechatConfig.notify_url);
            return payPrepareRet;

        } catch (Exception e) {
            e.printStackTrace();

            return null;

        }
    }

    private static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        int number = 0;
        for (int i = 0; i < length; i++) {
            number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }


}
