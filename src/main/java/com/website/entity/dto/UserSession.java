package com.website.entity.dto;

import com.website.entity.po.UserInfo;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserSession implements Serializable {

    //clientId
    private String clientId;
    //角色
    private String role;
    //用户信息
    private User user;

}
