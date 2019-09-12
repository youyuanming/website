package com.website.entity.dto;

import lombok.Data;

@Data
public class ClientResponse {
    //成功
    public final static String SUCCESS = "000000";
    //没有登录
    public final static String NO_LOGIN = "000001";


    //错误码
    private String code;
    //错误信息
    private String msg;

    public ClientResponse(){

    }

    public ClientResponse(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public static ClientResponse success(){
        return new ClientResponse(SUCCESS,null);
    }

    public static ClientResponse fail(String code,String msg){
        return new ClientResponse(code,msg);
    }

    public ClientResponse addCode(String code){
        this.code = code;
        return this;
    }

    public ClientResponse addMsg(String msg){
        this.msg = msg;
        return this;
    }
}
