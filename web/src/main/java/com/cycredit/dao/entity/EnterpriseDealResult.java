package com.cycredit.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class EnterpriseDealResult implements Serializable {
    private Long id;

    private String description;

    private String eid;

    private String name;

    private String code;

    private String dealType;

    private Long operator;

    private String operatorDepartmentCode;

    private String operatorAreaCode;

    private String tags;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid == null ? null : eid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType == null ? null : dealType.trim();
    }

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }

    public String getOperatorDepartmentCode() {
        return operatorDepartmentCode;
    }

    public void setOperatorDepartmentCode(String operatorDepartmentCode) {
        this.operatorDepartmentCode = operatorDepartmentCode == null ? null : operatorDepartmentCode.trim();
    }

    public String getOperatorAreaCode() {
        return operatorAreaCode;
    }

    public void setOperatorAreaCode(String operatorAreaCode) {
        this.operatorAreaCode = operatorAreaCode == null ? null : operatorAreaCode.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}