package com.cycredit.app.controller.credit.pojo.detail;

/**
 * Created by qiyubin on 2017/12/7 0007.
 *
 * @author qiyubin
 */
public class PersonInfo {

    private String pid;
    private String name;
    private String identityCard;
    private String address;

    public PersonInfo() {
    }

    public PersonInfo(String pid, String name, String identityCard, String address) {
        this.pid = pid;
        this.name = name;
        this.identityCard = identityCard;
        this.address = address;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
