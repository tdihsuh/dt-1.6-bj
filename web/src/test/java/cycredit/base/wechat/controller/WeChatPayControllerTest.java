package com.cycredit.base.wechat.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by qiyubin on 2017/7/4 0004.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:src/main/resources/spring/application.xml", "classpath:src/main/resources/servlet.xml"})
@WebAppConfiguration
public class WeChatPayControllerTest {


    private MockMvc mockMvc;
    @Autowired
    private WeChatPayController weChatPayController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(weChatPayController).build();
    }

    @Test
    public void wechatPay() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/app/pay/wechatpay").param("buyId", "1"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();

    }

}