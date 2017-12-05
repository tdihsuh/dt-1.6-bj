package com.cycredit.dao.entity;

import java.io.Serializable;

public class UniMemo implements Serializable {
    private Long id;

    private String name;

    private String source;

    private String relationDepartment;

    private String type;

    private String tags;

    private int status;

    private Long operator;

    private String operatorAreaCode;

    private String operatrorDepartmentCode;

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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
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

    public String getOperatorAreaCode() {
        return operatorAreaCode;
    }

    public void setOperatorAreaCode(String operatorAreaCode) {
        this.operatorAreaCode = operatorAreaCode == null ? null : operatorAreaCode.trim();
    }

    public String getOperatrorDepartmentCode() {
        return operatrorDepartmentCode;
    }

    public void setOperatrorDepartmentCode(String operatrorDepartmentCode) {
        this.operatrorDepartmentCode = operatrorDepartmentCode == null ? null : operatrorDepartmentCode.trim();
    }
}