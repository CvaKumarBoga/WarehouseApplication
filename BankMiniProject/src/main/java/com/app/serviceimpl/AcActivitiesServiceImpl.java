package com.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAcActivitiesDao;
import com.app.model.AccountActivities;
import com.app.service.IAcActivitiesService;
@Service
public class AcActivitiesServiceImpl implements IAcActivitiesService {

	@Autowired
	private IAcActivitiesDao dao;

	@Transactional
	@Override
	public String debitAmounnt(AccountActivities acno) {
		// TODO Auto-generated method stub
		return dao.debitAmounnt(acno);
	}
	@Transactional(readOnly = true)
	@Override
	public boolean isAccountNumberExist(String acNo) {
		// TODO Auto-generated method stub
		return dao.isAccountNumberExist(acNo);
	}
	@Transactional(readOnly = true)
	@Override
	public AccountActivities getOneAc(String accountNo) {
		// TODO Auto-generated method stub
		return dao.getOneAc(accountNo);
	}

	@Transactional
	@Override
	public void updateAmount(AccountActivities amount) {
		// TODO Auto-generated method stub
		dao.updateAmount(amount);
	}
	@Transactional(readOnly = true)
	@Override
	public List<AccountActivities> getall() {
		// TODO Auto-generated method stub
		return dao.getall();
	}
}
