package com.app.dao;

import java.util.List;

import com.app.model.AccountActivities;

public interface IAcActivitiesDao {
	
	public String debitAmounnt(AccountActivities acno);
	public boolean isAccountNumberExist(String acNo);
	public AccountActivities getOneAc(String accountNo);
	public void updateAmount(AccountActivities amount);
	public List<AccountActivities> getall();

}
