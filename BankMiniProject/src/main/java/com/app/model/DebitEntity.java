package com.app.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "debittab")
public class DebitEntity {

	@Id
	@GeneratedValue(generator = "referenceNo")
	@GenericGenerator(name = "referenceNo",strategy = "com.app.generator.CustomGeneratorDebit")
	private String referenceNo;
	private String debitAccountNo;
	private String IFCCode;
	private String debitType;
	@Transient
	private String fromAccount;
	private Double debitAmount;
	@Temporal(TemporalType.TIMESTAMP)
	private Date debitDate;
	//Many accounts one debit(by default collection type is Lazy)
	/*
	 * @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "accountIdFk") private List<AccountEntity>
	 * accountEntity=new ArrayList<AccountEntity>();
	 */
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "accountIdFk")
	private AccountActivities activities;
	public DebitEntity() {
		super();
	}
	public DebitEntity(String referenceNo, String debitAccountNo, String iFCCode, String debitType, String fromAccount,
			Double debitAmount, Date debitDate, AccountActivities activities) {
		super();
		this.referenceNo = referenceNo;
		this.debitAccountNo = debitAccountNo;
		IFCCode = iFCCode;
		this.debitType = debitType;
		this.fromAccount = fromAccount;
		this.debitAmount = debitAmount;
		this.debitDate = debitDate;
		this.activities = activities;
	}
	public String getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}
	public String getDebitAccountNo() {
		return debitAccountNo;
	}
	public void setDebitAccountNo(String debitAccountNo) {
		this.debitAccountNo = debitAccountNo;
	}
	public String getIFCCode() {
		return IFCCode;
	}
	public void setIFCCode(String iFCCode) {
		IFCCode = iFCCode;
	}
	public String getDebitType() {
		return debitType;
	}
	public void setDebitType(String debitType) {
		this.debitType = debitType;
	}
	public String getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Double getDebitAmount() {
		return debitAmount;
	}
	public void setDebitAmount(Double debitAmount) {
		this.debitAmount = debitAmount;
	}
	public Date getDebitDate() {
		return debitDate;
	}
	public void setDebitDate(Date debitDate) {
		this.debitDate = debitDate;
	}
	public AccountActivities getActivities() {
		return activities;
	}
	public void setActivities(AccountActivities activities) {
		this.activities = activities;
	}
	@Override
	public String toString() {
		return "DebitEntity [referenceNo=" + referenceNo + ", debitAccountNo=" + debitAccountNo + ", IFCCode=" + IFCCode
				+ ", debitType=" + debitType + ", fromAccount=" + fromAccount + ", debitAmount=" + debitAmount
				+ ", debitDate=" + debitDate + ", activities=" + activities + "]";
	}
	
}