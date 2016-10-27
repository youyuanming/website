package com.website.service.impl;

import com.website.dao.mapper.UserInfoMapper;
import com.website.entity.po.UserInfo;
import com.website.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by user on 16/10/27.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    /**
     * 通过用户名查询用户信息
     *
     * @param userName
     * @return
     */
    @Override
    public UserInfo findUserByUsername(String userName) {
        return userInfoMapper.findUserByUsername(userName);
    }
}
