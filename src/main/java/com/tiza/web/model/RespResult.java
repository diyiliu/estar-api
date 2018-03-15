package com.tiza.web.model;

/**
 * Description: RespResult
 * Author: DIYILIU
 * Update: 2017-12-08 10:50
 */
public class RespResult {

    private Integer ret = 0;
    private String msg = "";
    private Object Data;

    private String sig = "";

    public Integer getRet() {
        return ret;
    }

    public void setRet(Integer ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }
}
