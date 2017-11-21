package com.cycredit.migrate;

import org.apache.ibatis.migration.MigrationScript;

import java.math.BigDecimal;

/**
 * Created by qiyubin on 2017/6/26 0026.
 */
public class ChangeUser1 implements MigrationScript {


    @Override
    public BigDecimal getId() {
        return BigDecimal.valueOf(3L);
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String getUpScript() {
        return "ALTER TABLE `user`\n" +
                "MODIFY COLUMN `id`  bigint(20) NOT NULL AUTO_INCREMENT FIRST ;\n" +
                "ADD COLUMN `password`  varchar(60) NULL COMMENT '密码' AFTER `user_name`,\n" +
                "ADD COLUMN `mobilephone`  varchar(18) NULL COMMENT '手机号' AFTER `password`,\n" +
                "ADD COLUMN `create_time`  timestamp NULL COMMENT '创建时间' AFTER `mobilephone`,\n" +
                "ADD COLUMN `login_ip`  varchar(15) NULL COMMENT '登录Ip' AFTER `create_time`,\n" +
                "ADD COLUMN `login_time`  timestamp NULL COMMENT '登录时间' AFTER `login_ip`,\n" +
                "ADD COLUMN `old_login_ip`  varchar(15) NULL COMMENT '上次登录ip' AFTER `login_time`,\n" +
                "ADD COLUMN `old_login_time`  timestamp NULL COMMENT '上次登录时间' AFTER `old_login_ip`,\n" +
                "ADD COLUMN `head_pic`  varchar(255) NULL COMMENT '头像' AFTER `old_login_time`;\n" +
                "ADD UNIQUE INDEX `uq_username` (`username`) USING BTREE ;\n";
    }

    @Override
    public String getDownScript() {
        return "DROP TABLE `user`";
    }
}
