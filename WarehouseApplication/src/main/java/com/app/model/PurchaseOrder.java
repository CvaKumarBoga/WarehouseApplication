package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PurchaseOrder_tab")
public class PurchaseOrder {
	@Id
	@GeneratedValue
	@Column(name="pid")
	private Integer id;
	
	@Column(name="ocode")
	private String orderCode;
	
	@Column(name="rnummber")
	private Integer referenceNmber;
	
	@Column(name="qtcheck")
	private String qualiyCheck;
	
	@Column(name="status")
	private String dafaultStatus;
	
	@Column(name="pnote")
	private String note;
	
	@ManyToOne
	@JoinColumn(name="purStfk")
	private ShipmentType stype;
	
	@ManyToOne
	@JoinColumn(name="purWhfk")
	private WhUserType whuser;

	public PurchaseOrder() {
		super();
	}

	public PurchaseOrder(Integer id) {
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

	public Integer getReferenceNmber() {
		return referenceNmber;
	}

	public void setReferenceNmber(Integer referenceNmber) {
		this.referenceNmber = referenceNmber;
	}

	public String getQualiyCheck() {
		return qualiyCheck;
	}

	public void setQualiyCheck(String qualiyCheck) {
		this.qualiyCheck = qualiyCheck;
	}

	public String getDafaultStatus() {
		return dafaultStatus;
	}

	public void setDafaultStatus(String dafaultStatus) {
		this.dafaultStatus = dafaultStatus;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public ShipmentType getStype() {
		return stype;
	}

	public void setStype(ShipmentType stype) {
		this.stype = stype;
	}

	public WhUserType getWhuser() {
		return whuser;
	}

	public void setWhuser(WhUserType whuser) {
		this.whuser = whuser;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [id=" + id + ", orderCode=" + orderCode + ", referenceNmber=" + referenceNmber
				+ ", qualiyCheck=" + qualiyCheck + ", dafaultStatus=" + dafaultStatus + ", note=" + note + ", stype="
				+ stype + ", whuser=" + whuser + "]";
	}

}