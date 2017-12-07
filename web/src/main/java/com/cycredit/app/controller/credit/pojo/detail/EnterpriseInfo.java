package com.cycredit.app.controller.credit.pojo.detail;

/**
 * Created by qiyubin on 2017/12/7 0007.
 *
 * @author qiyubin
 */
public class EnterpriseInfo {

    private String eid;
    private String code;
    private String name;
    private String legalPerson;
    private String type;
    private String address;
    private String createTime;
    private String validTime;

    public EnterpriseInfo() {
    }

    public EnterpriseInfo(String eid, String code, String name, String legalPerson, String type, String address, String createTime, String validTime) {
        this.eid = eid;
        this.code = code;
        this.name = name;
        this.legalPerson = legalPerson;
        this.type = type;
        this.address = address;
        this.createTime = createTime;
        this.validTime = validTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getValidTime() {
        return validTime;
    }

    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }

}
