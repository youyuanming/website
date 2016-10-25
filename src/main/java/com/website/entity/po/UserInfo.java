/**
 * 
 */
package com.website.entity.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author youyuanming
 *
 */
@Entity
@Table(name = "user_info")
@Getter
@Setter
public class UserInfo{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false, name="user_name")
	private String userName;
	@Column(name="real_name")
	private String realName;
	
}
