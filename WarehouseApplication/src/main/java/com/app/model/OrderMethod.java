package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Order_Tab")
public class OrderMethod {
	
	@Id
	@GeneratedValue
	@Column(name="oid")
	private Integer id;
	@Column(name="omode")
	private String orderMode;
	@Column(name="ocode")
	private String orderCode;
	@Column(name="oextype")
	private String exeuteType;
	@Column(name="oaccept")
	private String orderAccept;
	@Column(name="onote")
	private String note;
	public OrderMethod() {
		super();
	}
	public OrderMethod(String orderMode, String orderCode, String exeuteType, String orderAccept, String note) {
		super();
		this.orderMode = orderMode;
		this.orderCode = orderCode;
		this.exeuteType = exeuteType;
		this.orderAccept = orderAccept;
		this.note = note;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderMode() {
		return orderMode;
	}
	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getExeuteType() {
		return exeuteType;
	}
	public void setExeuteType(String exeuteType) {
		this.exeuteType = exeuteType;
	}
	public String getOrderAccept() {
		return orderAccept;
	}
	public void setOrderAccept(String orderAccept) {
		this.orderAccept = orderAccept;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "OrderMethod [id=" + id + ", orderMode=" + orderMode + ", orderCode=" + orderCode + ", exeuteType="
				+ exeuteType + ", orderAccept=" + orderAccept + ", note=" + note + "]";
	}
	
}
