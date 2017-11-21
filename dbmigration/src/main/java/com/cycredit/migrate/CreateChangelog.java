package com.cycredit.migrate;

import org.apache.ibatis.migration.MigrationScript;

import java.math.BigDecimal;

/**
 * Created by qiyubin on 2017/6/26 0026.
 */
public class CreateChangelog implements MigrationScript {

    @Override
    public BigDecimal getId() {
        return BigDecimal.valueOf(1L);
    }

    @Override
    public String getDescription() {
        return "Create changelog";
    }

    @Override
    public String getUpScript() {
        return "CREATE TABLE CHANGELOG (\n" +
                "  ID BIGINT NOT NULL,\n" +
                "APPLIED_AT VARCHAR(25) NOT NULL,\n" +
                "DESCRIPTION VARCHAR(255) NOT NULL,\n" +
                "PRIMARY KEY (`ID`)\n" +
                ");";
    }

    @Override
    public String getDownScript() {
        return "DROP TABLE CHANGELOG;";
    }

}
