package com.website.biz;

import com.website.entity.po.UserInfo;

public interface UserBiz {
	/**
	 * 通过id获取用户信息
	 * @param id
	 * @return
	 */
	UserInfo findUserInfo(long id);
	
}
