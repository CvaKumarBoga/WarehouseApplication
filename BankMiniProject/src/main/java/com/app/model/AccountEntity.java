package com.app.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "accounttab")
public class AccountEntity {

	@Id
	private String accountNumber;
	private String IFCCode;
	private Integer serialNo;
	private String holderName;
	private Long mobileNo;
	private String holderEmail;
	private String dob;
	private String accountType;
	private String address;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Transient
	@ManyToOne
	private RegistrationEntity reg;

	@Transient
	@ManyToOne
	private AccountActivities act;

	public AccountEntity() {
		super();
	}

	public AccountEntity(String accountNumber, String iFCCode, Integer serialNo, String holderName, Long mobileNo,
			String holderEmail, String dob, String accountType, String address, Date date, RegistrationEntity reg,
			AccountActivities act) {
		super();
		this.accountNumber = accountNumber;
		IFCCode = iFCCode;
		this.serialNo = serialNo;
		this.holderName = holderName;
		this.mobileNo = mobileNo;
		this.holderEmail = holderEmail;
		this.dob = dob;
		this.accountType = accountType;
		this.address = address;
		this.date = date;
		this.reg = reg;
		this.act = act;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIFCCode() {
		return IFCCode;
	}

	public void setIFCCode(String iFCCode) {
		IFCCode = iFCCode;
	}

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getHolderEmail() {
		return holderEmail;
	}

	public void setHolderEmail(String holderEmail) {
		this.holderEmail = holderEmail;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public RegistrationEntity getReg() {
		return reg;
	}

	public void setReg(RegistrationEntity reg) {
		this.reg = reg;
	}

	public AccountActivities getAct() {
		return act;
	}

	public void setAct(AccountActivities act) {
		this.act = act;
	}

	@Override
	public String toString() {
		return "AccountEntity [accountNumber=" + accountNumber + ", IFCCode=" + IFCCode + ", serialNo=" + serialNo
				+ ", holderName=" + holderName + ", mobileNo=" + mobileNo + ", holderEmail=" + holderEmail + ", dob="
				+ dob + ", accountType=" + accountType + ", address=" + address + ", date=" + date + ", reg=" + reg
				+ ", act=" + act + "]";
	}

}