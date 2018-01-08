package com.cycredit.app.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;

/**
 * Created by qiyubin on 2018/1/8 0008.
 *
 * @author qiyubin
 */
public class HttpTest {
    public static void main(String[] args) throws IOException {
        HttpClient httpclient = new HttpClient();
        GetMethod getMethod = new GetMethod("http://www.baidu.com");
        getMethod.addRequestHeader("Content-Type", "text/html; charset=UTF-8");
        getMethod.getParams().setContentCharset("utf-8");
        httpclient.executeMethod(getMethod);
        System.out.println(getMethod.getResponseBodyAsString());
        getMethod.releaseConnection();
    }
}
