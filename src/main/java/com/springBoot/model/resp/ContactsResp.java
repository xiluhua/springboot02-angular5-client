package com.springBoot.model.resp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.springBoot.entity.Contacts;
import com.springBoot.entity.User;
import com.springBoot.model.Busi;
import lombok.Data;

import java.util.List;

/**
 * 统一响应模型 ~ 规范
 *
 * @author Tony
 * @since 2021/1/31
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ContactsResp extends Busi implements Resp {

    private List<Contacts> contactsList;

    public ContactsResp(StatusCode statusCode) {
        this.setCode(statusCode.getCode());
        this.setMsg(statusCode.getMsg());
    }

    public void setStatusCode(StatusCode statusCode) {
        this.setCode(statusCode.getCode());
        this.setMsg(statusCode.getMsg());
    }

    public ContactsResp() {

    }

}