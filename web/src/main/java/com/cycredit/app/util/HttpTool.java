package com.cycredit.app.util;

import com.cycredit.base.init.SystemLoader;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by qiyubin on 2018/1/8 0008.
 *
 * @author qiyubin
 */
public class HttpTool {
    private static Logger logger = LoggerFactory.getLogger(SystemLoader.class);

    public static void main(String[] args) throws IOException {

    }

    public static String doGet(String url) throws IOException {
        try {
            logger.info(url);
            HttpClient httpclient = new HttpClient();
            GetMethod getMethod = new GetMethod(url);
            getMethod.addRequestHeader("Accept", "application/json; charset=UTF-8");
            getMethod.getParams().setContentCharset("utf-8");
            httpclient.executeMethod(getMethod);
            String res = getMethod.getResponseBodyAsString();
            getMethod.releaseConnection();
            logger.info(res);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
