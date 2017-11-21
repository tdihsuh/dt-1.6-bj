package com.cycredit.base.init;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by qiyubin on 2017/6/26 0026.
 */
@Component
public class SystemLoader implements InitializingBean {

    private static Logger logger = LoggerFactory.getLogger(SystemLoader.class);

    @Resource
    BasicDataSource dataSource;

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
