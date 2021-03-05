package com.app.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAccountEntityDao;
import com.app.model.AccountEntity;
import com.app.service.IAccountEntityService;
@Service
public class AccountEntityServiceImpl implements IAccountEntityService {

	@Autowired
	private IAccountEntityDao dao;

	@Override
	@Transactional
	public String saveAccountEntity(AccountEntity accountNumber) {
		// TODO Auto-generated method stub
		accountNumber.setDate(new Date());
		return dao.saveAccountEntity(accountNumber);
	}
	@Transactional(readOnly = true)
	@Override
	public List<AccountEntity> getAllAccounts() {
		// TODO Auto-generated method stub
		return dao.getAllAccounts();
	}
	@Transactional(readOnly = true)
	@Override
	public AccountEntity getOneAccount(String accountNumber) {
		// TODO Auto-generated method stub
		return dao.getOneAccount(accountNumber);
	}
	@Override
	@Transactional
	public void updateAccount(AccountEntity ae) {
		// TODO Auto-generated method stub
		dao.updateAccount(ae);
	}
	@Override
	@Transactional(readOnly = true)
	public boolean isAccountNumberExist(String accountNumber) {
		// TODO Auto-generated method stub
		return dao.isAccountNumberExist(accountNumber);

	}
	@Override
	@Transactional(readOnly = true)
	public boolean isIFCCodeExist(String IFCCode) {
		// TODO Auto-generated method stub
		return dao.isIFCCodeExist(IFCCode);
	}
	@Transactional(readOnly = true)
	@Override
	public List<AccountEntity> getAllAccountsStatus() {
		// TODO Auto-generated method stub
		return dao.getAllAccountsStatus();
	}
	@Transactional(readOnly = true)
	@Override
	public Map<String, List<String>> checkAccountType(String accountType) {
		// TODO Auto-generated method stub
		return dao.checkAccountType(accountType);
	}
}
