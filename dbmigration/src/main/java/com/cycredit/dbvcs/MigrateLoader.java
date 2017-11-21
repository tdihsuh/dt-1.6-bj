package com.cycredit.dbvcs;

import com.alibaba.fastjson.JSONObject;
import com.cycredit.base.init.SystemLoader;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.migration.DataSourceConnectionProvider;
import org.apache.ibatis.migration.JavaMigrationLoader;
import org.apache.ibatis.migration.operations.StatusOperation;
import org.apache.ibatis.migration.operations.UpOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by qiyubin on 2017/6/26 0026.
 */
@Component
public class MigrateLoader implements InitializingBean {

    private static Logger logger = LoggerFactory.getLogger(SystemLoader.class);

    @Resource
    BasicDataSource dataSource;

    @Override
    public void afterPropertiesSet() throws Exception {

        logger.info(JSONObject.toJSONString(new StatusOperation().operate(new DataSourceConnectionProvider(dataSource), new JavaMigrationLoader("com/cycredit/migrate"), null, null).getCurrentStatus()));

        new UpOperation().operate(
                new DataSourceConnectionProvider(dataSource),
                new JavaMigrationLoader("com/cycredit/migrate"), null, null);
    }

}
