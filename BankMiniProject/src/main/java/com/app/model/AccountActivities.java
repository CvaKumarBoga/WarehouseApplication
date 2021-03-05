package com.app.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
@Entity
public class AccountActivities {
	@Id
	private String acNo;
	private String ifcCode;
	private String hdName;
	@Transient
	private byte[] photo;
	private Date date;
	private Double amount;
	@Transient
	@ManyToOne
	private AccountEntity accountEntity;
	public AccountActivities() {
		super();
	}
	public AccountActivities(String acNo, String ifcCode, String hdName, byte[] photo, Date date, Double amount,
			AccountEntity accountEntity) {
		super();
		this.acNo = acNo;
		this.ifcCode = ifcCode;
		this.hdName = hdName;
		this.photo = photo;
		this.date = date;
		this.amount = amount;
		this.accountEntity = accountEntity;
	}
	public String getAcNo() {
		return acNo;
	}
	public void setAcNo(String acNo) {
		this.acNo = acNo;
	}
	public String getIfcCode() {
		return ifcCode;
	}
	public void setIfcCode(String ifcCode) {
		this.ifcCode = ifcCode;
	}
	public String getHdName() {
		return hdName;
	}
	public void setHdName(String hdName) {
		this.hdName = hdName;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public AccountEntity getAccountEntity() {
		return accountEntity;
	}
	public void setAccountEntity(AccountEntity accountEntity) {
		this.accountEntity = accountEntity;
	}
	@Override
	public String toString() {
		return "AccountActivities [acNo=" + acNo + ", ifcCode=" + ifcCode + ", hdName=" + hdName + ", photo="
				+ Arrays.toString(photo) + ", date=" + date + ", amount=" + amount + ", accountEntity=" + accountEntity
				+ "]";
	}
	
}
