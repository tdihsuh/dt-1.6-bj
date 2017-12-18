package com.cycredit.app.controller.memo.pojo;

/**
 * Created by qiyubin on 2017/12/18 0018.
 *
 * @author qiyubin
 */
public class DepartmentMergeItem {

    private Long id;
    private String reason;
    private String measure;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
