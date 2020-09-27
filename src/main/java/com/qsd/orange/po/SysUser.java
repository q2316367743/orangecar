package com.qsd.orange.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

/**
 * 用户表
 * @author Esion
 * @version 1.0
 * @created 2020年9月23日 下午1:09:28
 */
@TableName("sys_user")
public class SysUser implements Serializable {

	private static final long serialVersionUID = 5546148053917409573L;
	@TableId(type = IdType.NONE)
	@NotBlank
	private String username;
	@Null
	private String password;
	@NotBlank
	private String identity;
	@NotBlank
	private String name;
	private Integer gender;
	private String address;
	private String phone;
	private String position;
	@Null
	private Integer type;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	

}
