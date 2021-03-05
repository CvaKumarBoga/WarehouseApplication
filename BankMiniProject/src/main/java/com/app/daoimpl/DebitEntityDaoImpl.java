package com.app.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IDebitEntityDao;
import com.app.model.DebitEntity;

@Repository
public class DebitEntityDaoImpl implements IDebitEntityDao{

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public String debitAmount(DebitEntity referenceNo) {
		// TODO Auto-generated method stub
		return (String) ht.save(referenceNo);
	}

}
