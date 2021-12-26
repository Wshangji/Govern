package com.govern.webservie.util;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: Nanf_bunan
 * @date: 2021-12-26 23-12
 */
public class Result implements Serializable {
    private boolean flag;
    private String msg;
    private Object data;

    public Result() {
    }

    public Result(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public Result(boolean flag, String msg, Object data) {
        this.flag = flag;
        this.msg = msg;
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result success(String msg, Object data) {
        return new Result(true, msg, data);
    }

    public static Result fail(String msg) {
        return new Result(false, msg);
    }
}
