package com.cycredit.app.controller.credit.pojo.detail;

import com.cycredit.dao.entity.UniMemoDepartment;

import java.util.List;

/**
 * Created by qiyubin on 2017/12/7 0007.
 *
 * @author qiyubin
 */
public class CreditMemoEntry {

    private String name;
    private String relationDepartment;
    private List<UniMemoDepartment> uniMemoDepartmentList;


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

    public List<UniMemoDepartment> getUniMemoDepartmentList() {
        return uniMemoDepartmentList;
    }

    public void setUniMemoDepartmentList(List<UniMemoDepartment> uniMemoDepartmentList) {
        this.uniMemoDepartmentList = uniMemoDepartmentList;
    }

    public CreditMemoEntry() {
    }

    public CreditMemoEntry(String name, String relationDepartment, List<UniMemoDepartment> uniMemoDepartmentList) {
        this.name = name;
        this.relationDepartment = relationDepartment;
        this.uniMemoDepartmentList = uniMemoDepartmentList;
    }
}
