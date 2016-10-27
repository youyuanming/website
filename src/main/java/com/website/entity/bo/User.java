package com.website.entity.bo;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String mobilePhone;
}
