package com.cycredit.app.util.authc;

import java.util.Date;

/**
 * Created by qiyubin on 2017/7/11 0011.
 */
public class UserToken {

    private Long uid;

    private String username;

    private String token;

    private Date createTime;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
