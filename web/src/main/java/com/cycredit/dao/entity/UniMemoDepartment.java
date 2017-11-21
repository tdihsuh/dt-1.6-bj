package com.cycredit.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class UniMemoDepartment implements Serializable {
    private Long id;

    private String department;

    private String reason;

    private String measure;

    private Long memoId;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure == null ? null : measure.trim();
    }

    public Long getMemoId() {
        return memoId;
    }

    public void setMemoId(Long memoId) {
        this.memoId = memoId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}