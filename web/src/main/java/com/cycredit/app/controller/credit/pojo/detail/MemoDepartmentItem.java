package com.cycredit.app.controller.credit.pojo.detail;

import java.util.Date;

/**
 * Created by qiyubin on 2017/12/7 0007.
 *
 * @author qiyubin
 */
public class MemoDepartmentItem {

    private Long id;

    private String departmentCode;

    private String reason;

    private String measure;


    private Long memoId;

    private Date createTime;

    private String memoName;

    public MemoDepartmentItem(String reason, String measure, String memoName) {
        this.reason = reason;
        this.measure = measure;
        this.memoName = memoName;
    }

    public MemoDepartmentItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
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

    public String getMemoName() {
        return memoName;
    }

    public void setMemoName(String memoName) {
        this.memoName = memoName;
    }
}
