package com.cycredit.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class AreaRank implements Serializable {
    private Integer id;

    private String areaCode;

    private String areaName;

    private Integer rank;

    private Integer uniCount;

    private Integer uniPunishCount;

    private Integer uniBonusCount;

    private Integer selectCount;

    private String activeCount;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getUniCount() {
        return uniCount;
    }

    public void setUniCount(Integer uniCount) {
        this.uniCount = uniCount;
    }

    public Integer getUniPunishCount() {
        return uniPunishCount;
    }

    public void setUniPunishCount(Integer uniPunishCount) {
        this.uniPunishCount = uniPunishCount;
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

    public String getActiveCount() {
        return activeCount;
    }

    public void setActiveCount(String activeCount) {
        this.activeCount = activeCount == null ? null : activeCount.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}