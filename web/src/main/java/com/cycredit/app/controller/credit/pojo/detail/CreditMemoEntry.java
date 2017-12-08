package com.cycredit.app.controller.credit.pojo.detail;

import com.cycredit.dao.entity.UniMemoDepartment;

import java.util.Date;
import java.util.List;

/**
 * Created by qiyubin on 2017/12/7 0007.
 *
 * @author qiyubin
 */
public class CreditMemoEntry {
    private Long memoId;
    private String type;
    private String name;
    private String relationDepartment;
    private List<MemoDepartmentItem> uniMemoDepartmentList;

    private Date time;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationDepartment() {
        return relationDepartment;
    }

    public void setRelationDepartment(String relationDepartment) {
        this.relationDepartment = relationDepartment;
    }

    public List<MemoDepartmentItem> getUniMemoDepartmentList() {
        return uniMemoDepartmentList;
    }

    public void setUniMemoDepartmentList(List<MemoDepartmentItem> uniMemoDepartmentList) {
        this.uniMemoDepartmentList = uniMemoDepartmentList;
    }

    public Long getMemoId() {
        return memoId;
    }

    public void setMemoId(Long memoId) {
        this.memoId = memoId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public CreditMemoEntry() {
    }


    public CreditMemoEntry(Long memoId, String type, String name, String relationDepartment, List<MemoDepartmentItem> uniMemoDepartmentList, Date time) {
        this.memoId = memoId;
        this.type = type;
        this.name = name;
        this.relationDepartment = relationDepartment;
        this.uniMemoDepartmentList = uniMemoDepartmentList;
        this.time = time;
    }
}
