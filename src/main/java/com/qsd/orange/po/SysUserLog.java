package com.qsd.orange.po;

import java.io.Serializable;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 系统日志 - 登录
 * @author Esion
 * @version 1.0
 * @created 2020年9月23日 下午3:14:03
 */
@TableName("sys_user_login")
public class SysUserLog implements Serializable {

	private static final long serialVersionUID = -273588836524291235L;
	@TableId(type = IdType.AUTO)
	private Integer id;
	@TableField("user_id")
	private Integer userId;
	@TableField("login_ip")
	private String loginIp;
	@TableField("login_time")
	private Timestamp loginTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public Timestamp getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

}
