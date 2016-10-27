package com.website.dao.mapper;

import com.website.entity.po.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper {

    int insert(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(UserInfo record);

    UserInfo findUserByUsername(@Param("userName") String userName);
}