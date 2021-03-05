package com.app.dao;

import java.util.List;
import java.util.Map;

import com.app.model.AccountEntity;

public interface IAccountEntityDao {
	
	public String saveAccountEntity(AccountEntity accountNumber);
	public List<AccountEntity> getAllAccounts();
	public AccountEntity getOneAccount(String accountNumber);
	public void updateAccount(AccountEntity ae);
	public boolean isAccountNumberExist(String accountNumber);
	public boolean isIFCCodeExist(String IFCCode);
	public List<AccountEntity> getAllAccountsStatus();
	
	public Map<String, List<String>> checkAccountType(String accountType);
	
	
}
