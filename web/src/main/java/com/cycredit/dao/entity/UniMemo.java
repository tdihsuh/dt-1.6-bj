package com.cycredit.dao.entity;

import java.io.Serializable;

public class UniMemo implements Serializable {
    private Long id;

    private String name;

    private String source;

    private String relationDepartment;

    private String type;

    private String tag;

    private int status;

    private Long operator;

    private String operatorArea;

    private String operatrorDepartment;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getRelationDepartment() {
        return relationDepartment;
    }

    public void setRelationDepartment(String relationDepartment) {
        this.relationDepartment = relationDepartment == null ? null : relationDepartment.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }

    public String getOperatorArea() {
        return operatorArea;
    }

    public void setOperatorArea(String operatorArea) {
        this.operatorArea = operatorArea == null ? null : operatorArea.trim();
    }

    public String getOperatrorDepartment() {
        return operatrorDepartment;
    }

    public void setOperatrorDepartment(String operatrorDepartment) {
        this.operatrorDepartment = operatrorDepartment == null ? null : operatrorDepartment.trim();
    }
}