package com.cycredit.base.utils.logic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by qiyubin on 2017/7/4 0004.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:src/main/resources/spring/application.xml", "classpath:src/main/resources/servlet.xml"})
@WebAppConfiguration
public class OrderUtilsTest {
    private static Logger logger = LoggerFactory.getLogger(OrderUtilsTest.class);


    @Test
    public void getOrderNumByType() throws Exception {
        String order = OrderUtils.getOrderNumByType(OrderUtils.OrderType.enterpriseSee);
        logger.info(order);
        assertNotNull(order);
        order = OrderUtils.getOrderNumByType(OrderUtils.OrderType.personSee);
        logger.info(order);
        assertNotNull(order);
    }

}