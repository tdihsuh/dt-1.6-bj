package com.cycredit.base.pojo;

/**
 * Created by qiyubin on 2017/9/1 0001.
 */
public class Response {

    private int code;
    private Object result;
    private String msg;

    public Response ok() {

        return new Response(0);
    }

    public static Response ok(String msg) {
        return new Response(0, msg);
    }

    public static Response ok(Object result, String msg) {
        return new Response(0, result, msg);
    }


    public static Response bad() {
        return new Response(1);
    }

    public static Response bad(String msg) {
        return new Response(1, msg);
    }

    public static Response bad(String result, String msg) {
        return new Response(1, result, msg);
    }


    public Response(int code) {
        this.code = code;
    }

    public Response(int code, Object result, String msg) {
        this.code = code;
        this.result = result;
        this.msg = msg;
    }

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
