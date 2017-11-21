package com.cycredit.migrate;

import org.apache.ibatis.migration.MigrationScript;

import java.math.BigDecimal;

/**
 * Created by qiyubin on 2017/6/26 0026.
 */
public class CreateUser implements MigrationScript {


    @Override
    public BigDecimal getId() {
        return BigDecimal.valueOf(2L);
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String getUpScript() {
        return "CREATE TABLE `user` (\n" +
                "`id`  bigint NOT NULL ,\n" +
                "`username`  varchar(50) NULL COMMENT '用户名' ,\n" +
                "PRIMARY KEY (`id`)\n" +
                ")\n" +
                ";";
    }

    @Override
    public String getDownScript() {
        return "DROP TABLE `user`";
    }
}
