package com.cycredit.app.controller.memo.pojo;

/**
 * Created by qiyubin on 2017/12/5 0005.
 *
 * @author qiyubin
 */
public class DepartmentItem {

    private Long id;
    private Long memoId;
    private String departmentName;
    private String departmentCode;
    private String reason;
    private String measure;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemoId() {
        return memoId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setMemoId(Long memoId) {
        this.memoId = memoId;
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
}
