package com.cycredit.common;

public class Tag {
    String code;
    String label;
    String type;//PUNISH 惩罚  BONUS 奖励

    public Tag() {
    }

    public Tag(String code, String label, String type) {
        this.code = code;
        this.label = label;
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}