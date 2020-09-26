package com.qsd.orange.po;

import java.io.Serializable;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 还车表
 * @author Esion
 * @version 1.0
 * @created 2020年9月23日 下午1:19:48
 */
@TableName("bus_check")
public class BusCheck implements Serializable {

	private static final long serialVersionUID = 7083995801146703176L;
	@TableId(type = IdType.NONE)
	private String id;
	@TableField("check_date")
	private Timestamp checkDate;
	private String description;
	private String problem;
	private Double compensate;
	private String operator;
	@TableField("rent_id")
	private String rentId;
	private Timestamp created;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Timestamp checkDate) {
		this.checkDate = checkDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public Double getCompensate() {
		return compensate;
	}
	public void setCompensate(Double compensate) {
		this.compensate = compensate;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getRentId() {
		return rentId;
	}
	public void setRentId(String rentId) {
		this.rentId = rentId;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	

}
