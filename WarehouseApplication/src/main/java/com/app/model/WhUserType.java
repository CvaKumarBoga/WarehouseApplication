package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="whuser_tab")
public class WhUserType {
	@Id
	@GeneratedValue
	@Column(name="uid")
	private Integer id;
	@Column(name="utype")
	private String userType;
	@Column(name="ucode")
	private String userCode;
	@Column(name="ufor")
	private String userFor;
	@Column(name="uemail")
	private String userEmail;
	@Column(name="ucontact")
	private String userContact;
	@Column(name="uidtype")
	private String userIdtype;
	@Column(name="unumber")
	private String idNumber;
	public WhUserType() {
		super();
	}
	public WhUserType(Integer id, String userType, String userCode, String userFor, String userEmail,
			String userContact, String userIdtype, String idNumber) {
		super();
		this.id = id;
		this.userType = userType;
		this.userCode = userCode;
		this.userFor = userFor;
		this.userEmail = userEmail;
		this.userContact = userContact;
		this.userIdtype = userIdtype;
		this.idNumber = idNumber;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserFor() {
		return userFor;
	}
	public void setUserFor(String userFor) {
		this.userFor = userFor;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public String getUserIdtype() {
		return userIdtype;
	}
	public void setUserIdtype(String userIdtype) {
		this.userIdtype = userIdtype;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	@Override
	public String toString() {
		return "WhUserType [id=" + id + ", userType=" + userType + ", userCode=" + userCode + ", userFor=" + userFor
				+ ", userEmail=" + userEmail + ", userContact=" + userContact + ", userIdtype=" + userIdtype
				+ ", idNumber=" + idNumber + "]";
	}
	
	
}
