package com.cycredit.base.utils.consts;

/**
 * Created by qiyubin on 2017/7/5 0005.
 */
public class Response {
    private String code;
    private Object obj;
    private String msg;

    static Response getResponse(String code, String msg, Object obj) {
        Response response = new Response();
        response.setCode(code);
        response.setMsg(msg);
        response.setObj(obj);
        return response;
    }

    public static Response success(String msg) {
        return getResponse("0", msg, null);
    }

    public static Response success(String msg, Object obj) {
        return getResponse("0", msg, obj);
    }

    public static Response success(String msg, Object obj, String code) {
        return getResponse(code, msg, obj);
    }


    public static Response fail(String msg) {
        return getResponse("1", msg, null);
    }

    public static Response fail(String msg, Object obj) {
        return getResponse("1", msg, obj);
    }

    public static Response fail(String msg, Object obj, String code) {
        return getResponse(code, msg, obj);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
