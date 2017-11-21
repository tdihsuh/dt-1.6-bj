package com.cycredit.base.wechat.pay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by qiyubin on 2017/7/4 0004.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:src/main/resources/spring/application.xml", "classpath:src/main/resources/servlet.xml"})
@WebAppConfiguration
public class WechatPrepareIdRequestUtilTest {
    private static Logger logger = LoggerFactory.getLogger(WechatPrepareIdRequestUtilTest.class);

    @Test
    public void perpareRequestXmlBody() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getHeader("x-forwarded-for")).thenReturn("127.0.0.1");
        when(request.getHeader("X-Real-IP")).thenReturn("127.0.0.1");
        String xmlBody = WechatPrepareIdRequestUtil.perpareRequestXmlBody(request, "1", 1l, "1");
        logger.info(xmlBody);
        assertNotNull(xmlBody);
    }

}