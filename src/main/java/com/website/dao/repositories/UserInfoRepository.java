package com.website.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.website.entity.po.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {

	/**
	 * 通过id查询user_info表
	 * @param id
	 * @return
	 */
	public UserInfo findUserInfoById(@Param("id") long id);
	
}
