package com.app.daoimpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ITransactionsDao;
import com.app.model.TransactionsEntity;
@Repository
public class TransactionsDaoImpl implements ITransactionsDao{

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public String saveTransaction(TransactionsEntity tr) {
		return (String) ht.save(tr);
	}
	@Override
	public List<TransactionsEntity> getallTrans() {
		return ht.loadAll(TransactionsEntity.class);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TransactionsEntity> checkTransactions(String accountNo) {
		  DetachedCriteria criteria = DetachedCriteria.forClass(TransactionsEntity.class).add(Restrictions
		  .eq("accountNo", accountNo)); 
		  List<TransactionsEntity> list = (List<TransactionsEntity>) ht.findByCriteria(criteria); 
		  return list;
		 
	}

}
