package com.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IDebitEntityDao;
import com.app.model.DebitEntity;
import com.app.service.IDebitEntityService;
@Service
public class DebitEntittyServiceImpl implements IDebitEntityService{

	@Autowired
	private IDebitEntityDao dao;
	
	@Transactional
	@Override
	public String debitAmount(DebitEntity referenceNo) {
		// TODO Auto-generated method stub
		return dao.debitAmount(referenceNo);
	}

}
