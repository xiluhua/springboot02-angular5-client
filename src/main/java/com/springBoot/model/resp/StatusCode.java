package com.springBoot.model.resp;

/**
 * 接口的响应状态码
 * @author Tony
 */
public enum StatusCode {

    success(200,"success"),
    unknownException(1002,"unknownException"),
    tokenUnavailable(1003,"tokenUnavailable"),
    invalidParams(1004,"invalidParams"),
    networkException(1005,"networkException"),
    bundleAlreadyExist(1006,"bundleAlreadyExist"),
    dataException(1007,"dataException"),
    innerException(1008,"innerException"),
    outerException(1009,"outerException"),
    dataHandleException(1010,"dataHandleException"),
    ;

    private Integer code;
    private String msg;

    StatusCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
