package com.cycredit.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class DepartmentRank implements Serializable {
    private Integer id;

    private String departmentCode;

    private String departmentName;

    private Integer rank;

    private Integer joinCount;

    private Integer uniCount;

    private Integer uniPubnishCount;

    private Integer uniBonusCount;

    private Integer selectCount;

    private Integer activeCount;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode == null ? null : departmentCode.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getJoinCount() {
        return joinCount;
    }

    public void setJoinCount(Integer joinCount) {
        this.joinCount = joinCount;
    }

    public Integer getUniCount() {
        return uniCount;
    }

    public void setUniCount(Integer uniCount) {
        this.uniCount = uniCount;
    }

    public Integer getUniPubnishCount() {
        return uniPubnishCount;
    }

    public void setUniPubnishCount(Integer uniPubnishCount) {
        this.uniPubnishCount = uniPubnishCount;
    }

    public Integer getUniBonusCount() {
        return uniBonusCount;
    }

    public void setUniBonusCount(Integer uniBonusCount) {
        this.uniBonusCount = uniBonusCount;
    }

    public Integer getSelectCount() {
        return selectCount;
    }

    public void setSelectCount(Integer selectCount) {
        this.selectCount = selectCount;
    }

    public Integer getActiveCount() {
        return activeCount;
    }

    public void setActiveCount(Integer activeCount) {
        this.activeCount = activeCount;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}