package com.springBoot.model;
import com.springBoot.model.resp.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 统一响应模型 ~ 规范
 * @author Tony
 * @since 2021/1/31
 **/
@Data
@AllArgsConstructor
public class Busi<T> {
    protected String txid;
    protected Integer code;
    protected String msg;
    protected String type;
    protected String service;
    protected String locale;
    protected T data;

    public Busi() {
    }

    public Busi(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }

    public Busi(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Busi(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

//    public void setType(Class clazz){
//        if (clazz.getName().indexOf("com.swissre.controller") > -1){
//            this.type = "1";
//        }
//        else if (clazz.getName().indexOf("com.swissre.service") > -1){
//            if (this.type.indexOf("1-2") < 0)
//                this.type = "1-2";
//        }
//        else if (clazz.getName().indexOf("com.swissre.serviceSub") > -1){
//            if (this.type.indexOf("1-2-3") < 0)
//                this.type = "1-2-3";
//        }
//    }
}