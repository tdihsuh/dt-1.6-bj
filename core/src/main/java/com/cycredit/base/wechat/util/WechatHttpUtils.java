package com.cycredit.base.wechat.util;

import com.cycredit.base.wechat.pay.pojo.PrepareOrder;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

/**
 * post提交xml格式的参数
 */
public class WechatHttpUtils {


    /**
     * 构造xml参数
     *
     * @return
     */
    public static String prepareOrderXmlInfo(PrepareOrder prepareOrder) {
        //构造xml参数的时候，至少又是个必传参数
        /*
         * <xml>
			   <appid>wx2421b1c4370ec43b</appid>
			   <attach>支付测试</attach>
			   <body>JSAPI支付测试</body>
			   <mch_id>10000100</mch_id>
			   <nonce_str>1add1a30ac87aa2db72f57a2375d8fec</nonce_str>
			   <notify_url>http://wxpay.weixin.qq.com/pub_v2/pay/notify.v2.php</notify_url>
			   <openid>oUpF8uMuAJO_M2pxb1Q9zNjWeS6o</openid>
			   <out_trade_no>1415659990</out_trade_no>
			   <spbill_create_ip>14.23.150.211</spbill_create_ip>
			   <total_fee>1</total_fee>
			   <trade_type>JSAPI</trade_type>
			   <sign>0CB01533B8C1EF103065174F50BCA001</sign>
			</xml>
		 */

        if (prepareOrder != null) {
            StringBuffer bf = new StringBuffer();
            bf.append("<xml>");

            bf.append("<appid><![CDATA[");
            bf.append(prepareOrder.getAppid());
            bf.append("]]></appid>");

            bf.append("<mch_id><![CDATA[");
            bf.append(prepareOrder.getMch_id());
            bf.append("]]></mch_id>");

            bf.append("<nonce_str><![CDATA[");
            bf.append(prepareOrder.getNonce_str());
            bf.append("]]></nonce_str>");

            bf.append("<sign><![CDATA[");
            bf.append(prepareOrder.getSign());
            bf.append("]]></sign>");

            bf.append("<body><![CDATA[");
            bf.append(prepareOrder.getBody());
            bf.append("]]></body>");

            bf.append("<detail><![CDATA[");
            bf.append(prepareOrder.getDetail());
            bf.append("]]></detail>");

            bf.append("<attach><![CDATA[");
            bf.append(prepareOrder.getAttach());
            bf.append("]]></attach>");

            bf.append("<out_trade_no><![CDATA[");
            bf.append(prepareOrder.getOut_trade_no());
            bf.append("]]></out_trade_no>");

            bf.append("<total_fee><![CDATA[");
            bf.append(prepareOrder.getTotal_fee());
            bf.append("]]></total_fee>");

            bf.append("<spbill_create_ip><![CDATA[");
            bf.append(prepareOrder.getSpbill_create_ip());
            bf.append("]]></spbill_create_ip>");

            bf.append("<time_start><![CDATA[");
            bf.append(prepareOrder.getTime_start());
            bf.append("]]></time_start>");

            bf.append("<time_expire><![CDATA[");
            bf.append(prepareOrder.getTime_expire());
            bf.append("]]></time_expire>");

            bf.append("<notify_url><![CDATA[");
            bf.append(prepareOrder.getNotify_url());
            bf.append("]]></notify_url>");

            bf.append("<trade_type><![CDATA[");
            bf.append(prepareOrder.getTrade_type());
            bf.append("]]></trade_type>");


            bf.append("</xml>");
            return bf.toString();
        }

        return "";
    }


    /**
     * post请求并得到返回结果
     *
     * @param requestUrl
     * @param requestMethod
     * @param output
     * @return
     */
    public static String httpsRequest(String requestUrl, String requestMethod, String output) {
        try {
            URL url = new URL(requestUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod(requestMethod);
            if (null != output) {
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(output.getBytes("UTF-8"));
                outputStream.close();
            }
            // 从输入流读取返回内容
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            connection.disconnect();
            return buffer.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "";
    }

}
