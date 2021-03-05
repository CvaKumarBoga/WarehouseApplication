package com.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICreditEntityDao;
import com.app.model.CreditEntity;
import com.app.service.ICreditEntityService;
@Service
public class CreditEntityServiceImpl implements ICreditEntityService{

	@Autowired
	private ICreditEntityDao dao;
	
	@Transactional
	@Override
	public String creditAmount(CreditEntity acNo) {
		// TODO Auto-generated method stub
		return dao.creditAmount(acNo);
	}

}
