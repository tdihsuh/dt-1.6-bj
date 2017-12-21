package com.cycredit.app.controller.memo.pojo;

import java.util.Date;

/**
 * Created by qiyubin on 2017/12/20 0020.
 *
 * @author qiyubin
 */
public class MemoItem {

    private Long id;

    private String name;

    private String source;

    private String relationDepartment;

    private String type;

    private String tags;

    private Integer departmentCount;

    private int status;

    private Long operator;

    private String operatorAreaCode;

    private String operatrorDepartmentCode;

    private Date createTime;

    private Date updateTime;

    private String operatorName;

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
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRelationDepartment() {
        return relationDepartment;
    }

    public void setRelationDepartment(String relationDepartment) {
        this.relationDepartment = relationDepartment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getDepartmentCount() {
        return departmentCount;
    }

    public void setDepartmentCount(Integer departmentCount) {
        this.departmentCount = departmentCount;
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
        this.operatorAreaCode = operatorAreaCode;
    }

    public String getOperatrorDepartmentCode() {
        return operatrorDepartmentCode;
    }

    public void setOperatrorDepartmentCode(String operatrorDepartmentCode) {
        this.operatrorDepartmentCode = operatrorDepartmentCode;
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

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
}
