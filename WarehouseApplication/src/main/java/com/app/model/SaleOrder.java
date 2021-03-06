package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="saleOrder_tab")
public class SaleOrder {
	@Id
	@GeneratedValue
	@Column(name="oid")
	private Integer id;
	@Column(name="ocode")
	private String orderCode;
	
	@ManyToOne
	@JoinColumn(name="ordsipfk")
	private ShipmentType shipment;
	
	@ManyToOne
	@JoinColumn(name="ordwhfk")
	private WhUserType whuser;
	
	@Column(name="refNumber")
	private String refNumber;
	@Column(name="sMode")
	private String stockMode;
	@Column(name="stock")
	private String stockSource;
	@Column(name="status")
	private String defaultStatus;
	@Column(name="onote")
	private String note;
	public SaleOrder() {
		super();
	}
	public SaleOrder(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public ShipmentType getShipment() {
		return shipment;
	}
	public void setShipment(ShipmentType shipment) {
		this.shipment = shipment;
	}
	public WhUserType getWhuser() {
		return whuser;
	}
	public void setWhuser(WhUserType whuser) {
		this.whuser = whuser;
	}
	public String getRefNumber() {
		return refNumber;
	}
	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}
	public String getStockMode() {
		return stockMode;
	}
	public void setStockMode(String stockMode) {
		this.stockMode = stockMode;
	}
	public String getStockSource() {
		return stockSource;
	}
	public void setStockSource(String stockSource) {
		this.stockSource = stockSource;
	}
	public String getDefaultStatus() {
		return defaultStatus;
	}
	public void setDefaultStatus(String defaultStatus) {
		this.defaultStatus = defaultStatus;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "SaleOrder [id=" + id + ", orderCode=" + orderCode + ", shipment=" + shipment + ", whuser=" + whuser
				+ ", refNumber=" + refNumber + ", stockMode=" + stockMode + ", stockSource=" + stockSource
				+ ", defaultStatus=" + defaultStatus + ", note=" + note + "]";
	}
}