package edu.gd.test.entity;

public class BaseResponse<E> {

    private int code;
    private String msg;
    private E data;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public E getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(E data) {
        this.data = data;
    }

    public BaseResponse(int code, String msg, E data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResponse() {}
}
