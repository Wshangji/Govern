package com.govern.webservie.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author: Nanf_bunan
 * @date: 2021-12-26 23-12
 */
@ApiModel(value = "响应参数")
public class Result implements Serializable {

    @ApiModelProperty(value = "响应是否成功" ,dataType = "boolean")
    private boolean flag;

    @ApiModelProperty(value = "响应信息" ,dataType = "String")
    private String msg;

    @ApiModelProperty(value = "响应数据" ,dataType = "Object")
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
