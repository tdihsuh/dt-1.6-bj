package com.cycredit.app.controller.credit.pojo.detail;

/**
 * Created by qiyubin on 2017/12/7 0007.
 *
 * @author qiyubin
 */
public class CreditDetailEntry {
    String key;
    String value;

    public CreditDetailEntry() {
    }

    public CreditDetailEntry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
