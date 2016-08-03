package com.website.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.biz.UserBiz;
import com.website.dao.repositories.UserInfoRepository;
import com.website.entity.po.UserInfo;


@Service
public class UserBizImpl implements UserBiz {

	@Autowired
	private UserInfoRepository userInfoRepository;//user_info
	
	@Override
	public UserInfo findUserInfo(long id) {
		return userInfoRepository.findUserInfoById(id);
	}

}
