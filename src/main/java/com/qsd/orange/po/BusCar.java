package com.qsd.orange.po;

import java.io.Serializable;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * 汽车表
 * @author Esion
 * @version 1.0
 * @created 2020年9月23日 下午1:15:09
 */
@TableName("bus_car")
public class BusCar implements Serializable {

	private static final long serialVersionUID = 7074654537514458969L;
	@TableId(type = IdType.NONE)
	@NotBlank
	private String number;
	@NotBlank
	private String brand;
	@NotBlank
	private String color;
	@TableField("buy_price")
	@NotNull
	private Double buyPrice;
	@TableField("rent_price")
	@NotNull
	private Double rentPrice;
	//押金
	@NotNull
	private Double deposit;
	//出租状态
	@Null
	private Integer status;
	@NotBlank
	private String description;
	@NotBlank
	private String image;
	@Null
	@JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone="GMT+8")
	private Timestamp created;
	@Null
	private String operator;
	@Null
	private Integer exist;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public Double getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(Double rentPrice) {
		this.rentPrice = rentPrice;
	}
	public Double getDeposit() {
		return deposit;
	}
	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public Integer getExist() {
		return exist;
	}
	public void setExist(Integer exist) {
		this.exist = exist;
	}
}
