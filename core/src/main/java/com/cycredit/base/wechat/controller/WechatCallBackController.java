package com.cycredit.base.wechat.controller;

import com.cycredit.base.wechat.util.WechatSignUtils;
import com.cycredit.base.wechat.util.WechatXmlParseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * 微信回调
 * <p>
 * Created by qiyubin on 2017/5/17.
 */
@Controller
@RequestMapping("/app/wechat/pay")
public class WechatCallBackController {

    private static Logger logger = LoggerFactory.getLogger(WechatCallBackController.class);


    @ResponseBody
    @RequestMapping("/callBack")
    public String wechatPayCallBack(HttpServletRequest request, HttpServletResponse response) {


        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/xml");
        try {

            String resxml = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));
            Map<String, String> restmap = WechatXmlParseUtils.jdomParseXmlToMap(resxml);

            if ("SUCCESS".equals(restmap.get("return_code"))) {
                // 订单支付成功 业务处理
                String out_trade_no = restmap.get("out_trade_no"); // 商户订单号
                // 通过商户订单判断是否该订单已经处理 如果处理跳过 如果未处理先校验sign签名 再进行订单业务相关的处理
//                CatOrder order = orderService.getOrderByOrderId(out_trade_no);
//                if (order == null) {
//                    logger.info("微信返回的订单号找不到,订单号:" + out_trade_no);
//                }
//                //已经支付成功过
//                if (order.getStatus().equals(OrderUtils.OrderStatus.paid.name())) {
//                    logger.info("订单曾经支付成功过,订单号:" + out_trade_no);
//                }


                //验证签名
                String sing = restmap.get("sign"); // 返回的签名
                restmap.remove("sign");

                Map<Object, Object> sortMap = WechatSignUtils.sortMap(restmap);

                String signnow = WechatSignUtils.createSign("UTF-8", sortMap);
                if (signnow.equals(sing)) {

                    // 进行业务处理
                    logger.info("订单支付通知： 支付成功，订单号" + out_trade_no);
//                    //设置支付成功状态
//                    orderService.updateOrderSucess(order);
//                    //清理同用户重复购买的订单
//                    orderService.cleanOrder(order);
                    //获取预约单
                    // subscribeService.createSubscribe(order);
                    //返回微信成功状态
                    String xmlInfo = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
                    response.getWriter().write(xmlInfo);
                } else {
                    logger.info("订单支付通知：签名错误");
                }
            } else {
                logger.info("订单支付通知：支付失败，" + restmap.get("err_code") + ":" + restmap.get("err_code_des"));
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }


}
