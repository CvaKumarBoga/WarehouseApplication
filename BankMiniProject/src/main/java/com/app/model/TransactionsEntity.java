package com.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class TransactionsEntity {
	@Id
	private String refNumber;
	private String accountNo;
	private String name;
	private Date date;
	private String type;
	private Double amount;
	@ManyToOne
	private AccountActivities ac;
	public TransactionsEntity() {
		super();
	}
	public TransactionsEntity(String refNumber, String accountNo, String name, Date date, String type, Double amount,
			AccountActivities ac) {
		super();
		this.refNumber = refNumber;
		this.accountNo = accountNo;
		this.name = name;
		this.date = date;
		this.type = type;
		this.amount = amount;
		this.ac = ac;
	}
	public String getRefNumber() {
		return refNumber;
	}
	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public AccountActivities getAc() {
		return ac;
	}
	public void setAc(AccountActivities ac) {
		this.ac = ac;
	}
	
}
