package com.app.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICreditEntityDao;
import com.app.model.CreditEntity;
@Repository
public class CreditEntityDaoImpl implements ICreditEntityDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public String creditAmount(CreditEntity acNo) {
		// TODO Auto-generated method stub
		return (String) ht.save(acNo);
	}

}
