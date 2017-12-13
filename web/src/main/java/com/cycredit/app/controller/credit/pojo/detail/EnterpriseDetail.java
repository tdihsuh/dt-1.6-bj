package com.cycredit.app.controller.credit.pojo.detail;

import java.util.List;

/**
 * Created by qiyubin on 2017/11/29 0029.
 *
 * @author qiyubin
 */
public class EnterpriseDetail {

    EnterpriseInfo info;
    List<CreditMemoEntry> creditMemoList;
    List<EventDetail> creditDetailList;

    public EnterpriseInfo getInfo() {
        return info;
    }

    public void setInfo(EnterpriseInfo info) {
        this.info = info;
    }

    public List<CreditMemoEntry> getCreditMemoList() {
        return creditMemoList;
    }

    public void setCreditMemoList(List<CreditMemoEntry> creditMemoList) {
        this.creditMemoList = creditMemoList;
    }

    public List<EventDetail> getCreditDetailList() {
        return creditDetailList;
    }

    public void setCreditDetailList(List<EventDetail> creditDetailList) {
        this.creditDetailList = creditDetailList;
    }
}
