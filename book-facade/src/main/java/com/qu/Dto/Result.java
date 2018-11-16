package com.qu.Dto;

import java.io.Serializable;

/**
 * Created by 96283 on 2018/11/8.
 */
public class Result implements Serializable{
    private String code;
    private String message;
    private Object data;

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result success(Object data){
        return new Result("0","请求成功",data);
    }
    public static Result success(){
        return new Result("0","请求成功");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
