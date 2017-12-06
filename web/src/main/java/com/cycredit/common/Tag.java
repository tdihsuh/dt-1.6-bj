package com.cycredit.common;

public class Tag {
    String label;
    String type;

    public Tag() {
    }

    public Tag(String label, String type) {
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
}