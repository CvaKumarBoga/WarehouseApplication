package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="uom_tab")
public class UomType {
	@Id
	@GeneratedValue
	@Column(name="uid")
	private Integer id;
	@Column(name="utype")
	private String uomType;
	@Column(name="umodel")
	private String uomModel;
	@Column(name="unote")
	private String note;
	public UomType() {
		super();
	}
	public UomType(String uomType, String uomModel, String note) {
		super();
		this.uomType = uomType;
		this.uomModel = uomModel;
		this.note = note;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUomType() {
		return uomType;
	}
	public void setUomType(String uomType) {
		this.uomType = uomType;
	}
	public String getUomModel() {
		return uomModel;
	}
	public void setUomModel(String uomModel) {
		this.uomModel = uomModel;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "UomType [id=" + id + ", uomType=" + uomType + ", uomModel=" + uomModel + ", note=" + note + "]";
	}
	
}