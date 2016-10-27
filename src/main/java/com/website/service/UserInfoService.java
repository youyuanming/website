package com.website.service;

import com.website.entity.po.UserInfo;

/**
 * Created by user on 16/10/27.
 */
public interface UserInfoService {

    /**
     * 通过用户名查询用户信息
     * @param userName
     * @return
     */
    UserInfo findUserByUsername(String userName);

}
