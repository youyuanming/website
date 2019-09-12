package com.website.entity.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * 用户对象
 */
@Data
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String mobilePhone;
}
