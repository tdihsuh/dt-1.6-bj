package com.cycredit.rule.range.pojo;

/**
 * Created by qiyubin on 2017/8/30 0030.
 *
 * @author qiyubin
 */
public class Condition {
    Object point;

    Object eqObj;
    Object startObj;
    Boolean isEqStart = false;
    Object endObj;
    Boolean isEqEnd = false;
    Boolean isOther = false;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Object getEqObj() {
        return eqObj;
    }

    public void setEqObj(Object eqObj) {
        this.eqObj = eqObj;
    }

    public Object getStartObj() {
        return startObj;
    }

    public void setStartObj(Object startObj) {
        this.startObj = startObj;
    }

    public Boolean getEqStart() {
        return isEqStart;
    }

    public void setEqStart(Boolean eqStart) {
        isEqStart = eqStart;
    }

    public Object getEndObj() {
        return endObj;
    }

    public void setEndObj(Object endObj) {
        this.endObj = endObj;
    }

    public Boolean getEqEnd() {
        return isEqEnd;
    }

    public void setEqEnd(Boolean eqEnd) {
        isEqEnd = eqEnd;
    }

    public Object getPoint() {
        return point;
    }

    public void setPoint(Object point) {
        this.point = point;
    }

    public static Condition newInstance() {
        return new Condition();
    }

    public Condition result(Object result) {
        point = result;
        return this;

    }

    public Condition other() {
        isOther = true;
        return this;
    }


    public Condition eq(Object expectResult) {
        this.eqObj = expectResult;
        return this;
    }

    public Condition greatThan(Object expectStart) {
        this.startObj = expectStart;
        return this;
    }

    public Condition greatOrEqThan(Object expectStart) {
        this.startObj = expectStart;
        this.isEqStart = true;
        return this;
    }

    public Condition lessThan(Object expectEnd) {
        this.endObj = expectEnd;
        return this;
    }

    public Condition lessOrEqThan(Object expectEnd) {
        this.endObj = expectEnd;
        this.isEqEnd = true;
        return this;
    }
}