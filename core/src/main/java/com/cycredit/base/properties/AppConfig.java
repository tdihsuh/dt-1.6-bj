package com.cycredit.base.properties;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * Created by qiyubin on 2017/7/4 0004.
 */
@Component
public class AppConfig {

    @Resource
    Properties properties;

    public Properties getProperties() {
        return properties;
    }

}
