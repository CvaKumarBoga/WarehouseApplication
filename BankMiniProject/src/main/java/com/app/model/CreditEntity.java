package com.app.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class CreditEntity {
	
	@Id
	@GeneratedValue(generator = "referenceNo")
	@GenericGenerator(name = "referenceNo",strategy = "com.app.generator.CustomGeneratorCredit")
	private String refNo;
	private String acNo;
	private String name;
	private Double amount;
	private Date date;
	@Transient
	@ManyToOne
	private AccountActivities activities;
	@Transient
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private TransactionsEntity trans;
	public CreditEntity() {
		super();
	}
	public CreditEntity(String refNo, String acNo, String name, Double amount, Date date,
			AccountActivities activities) {
		super();
		this.refNo = refNo;
		this.acNo = acNo;
		this.name = name;
		this.amount = amount;
		this.date = date;
		this.activities = activities;
	}
	public String getRefNo() {
		return refNo;
	}
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	public String getAcNo() {
		return acNo;
	}
	public void setAcNo(String acNo) {
		this.acNo = acNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public AccountActivities getActivities() {
		return activities;
	}
	public void setActivities(AccountActivities activities) {
		this.activities = activities;
	}
	@Override
	public String toString() {
		return "CreditEntity [refNo=" + refNo + ", acNo=" + acNo + ", name=" + name + ", amount=" + amount + ", date="
				+ date + ", activities=" + activities + "]";
	}
	
}
