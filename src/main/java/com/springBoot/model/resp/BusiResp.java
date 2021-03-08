package com.springBoot.model.resp;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.springBoot.model.Busi;
import lombok.*;

/**
 * 统一响应模型 ~ 规范
 * @author Tony
 * @since 2021/1/31
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BusiResp extends Busi implements Resp {

    public BusiResp(StatusCode statusCode) {
         this.setCode(statusCode.getCode());
         this.setMsg(statusCode.getMsg());
    }

    public void setStatusCode(StatusCode statusCode){
        this.setCode(statusCode.getCode());
        this.setMsg(statusCode.getMsg());
    }

    public BusiResp() {

    }

}