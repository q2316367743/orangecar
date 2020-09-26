package com.qsd.orange.po;

import java.io.Serializable;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * 客户表
 * @author Esion
 * @version 1.0
 * @created 2020年9月23日 下午1:42:37
 */
@TableName("bus_customer")
public class BusCustomer implements Serializable {

	private static final long serialVersionUID = 6658064314710608402L;
	@TableId(type = IdType.NONE)
	@NotBlank
	private String identity;
	@NotBlank
	private String name;
	private Integer gender;
	private String address;
	private String phone;
	private String career;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone="GMT+8")
	@Null
	private Timestamp created;
	@Null
	private Boolean exist;
	@Null
	private String operator;
	
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
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Boolean getExist() {
		return exist;
	}

	public void setExist(Boolean exist) {
		this.exist = exist;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
}
