package com.cycredit.app.controller.credit.pojo.detail;

import java.util.List;

/**
 * Created by qiyubin on 2017/12/13 0013.
 *
 * @author qiyubin
 */
public class EventDetail {

    String eventName;
    List<CreditDetailEntry> eventDetail;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public List<CreditDetailEntry> getEventDetail() {
        return eventDetail;
    }

    public void setEventDetail(List<CreditDetailEntry> eventDetail) {
        this.eventDetail = eventDetail;
    }
}
