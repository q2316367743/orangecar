package com.qsd.orange.po;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 出租单号
 * @author Esion
 * @version 1.0
 * @created 2020年9月23日 下午1:49:45
 */
@TableName("bus_rent")
public class BusRent implements Serializable {

	private static final long serialVersionUID = 6129197607180087634L;
	@TableId(type = IdType.NONE)
	private String id;
	private Double price;
	@TableField("begin_time")
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	private Date beginTime;
	@TableField("return_time")
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	private Date returnTime;
	@TableField("rent_status")
	private Integer rentStatus;
	@TableField("customer_identity")
	private String customerIdentity;
	@TableField("car_number")
	private String carNumber;
	private String operator;
	private Timestamp created;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	public Integer getRentStatus() {
		return rentStatus;
	}
	public void setRentStatus(Integer rentStatus) {
		this.rentStatus = rentStatus;
	}
	public String getCustomerIdentity() {
		return customerIdentity;
	}
	public void setCustomerIdentity(String customerIdentity) {
		this.customerIdentity = customerIdentity;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}

}
