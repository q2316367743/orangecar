package com.qsd.orange.po;

import java.io.Serializable;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

/**
 * 系统通知
 * @author Esion
 * @version 1.0
 * @created 2020年9月23日 下午3:27:51
 */
@TableName("sys_announcement")
public class SysAnnouncement implements Serializable {

	private static final long serialVersionUID = 4845165626198699466L;
	@TableId(type = IdType.AUTO)
	@Null
	private Integer id;
	@NotBlank
	private String title;
	@NotBlank
	private String content;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone="GMT+8")
	@Null
	private Timestamp created;
	@Null
	private String operator;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}

}
