package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Shipment_Type_tab")
public class ShipmentType {
	@Id
	@GeneratedValue
	@Column(name="sid")
	private Integer id;
	@Column(name="smode")
	private String shipmentMode;
	@Column(name="scode")
	private String shipmentCode;
	@Column(name="enbshipment")
	private  String enableShipment;
	@Column(name="sgrade")
	private String shipmentGrade;
	@Column(name="snote")
	private String note;
	public ShipmentType() {
		super();
	}
	public ShipmentType(Integer id) {
		super();
		this.id = id;
	}
	public ShipmentType(Integer id, String shipmentMode, String shipmentCode, String enableShipment,
			String shipmentGrade, String note) {
		super();
		this.id = id;
		this.shipmentMode = shipmentMode;
		this.shipmentCode = shipmentCode;
		this.enableShipment = enableShipment;
		this.shipmentGrade = shipmentGrade;
		this.note = note;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getShipmentMode() {
		return shipmentMode;
	}
	public void setShipmentMode(String shipmentMode) {
		this.shipmentMode = shipmentMode;
	}
	public String getShipmentCode() {
		return shipmentCode;
	}
	public void setShipmentCode(String shipmentCode) {
		this.shipmentCode = shipmentCode;
	}
	public String getEnableShipment() {
		return enableShipment;
	}
	public void setEnableShipment(String enableShipment) {
		this.enableShipment = enableShipment;
	}
	public String getShipmentGrade() {
		return shipmentGrade;
	}
	public void setShipmentGrade(String shipmentGrade) {
		this.shipmentGrade = shipmentGrade;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "ShipmentType [id=" + id + ", shipmentMode=" + shipmentMode + ", shipmentCode=" + shipmentCode
				+ ", enableShipment=" + enableShipment + ", shipmentGrade=" + shipmentGrade + ", note=" + note + "]";
	}
	
	
}
