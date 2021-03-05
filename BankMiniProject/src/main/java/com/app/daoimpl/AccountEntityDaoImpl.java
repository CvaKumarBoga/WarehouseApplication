package com.app.daoimpl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.app.dao.IAccountEntityDao;
import com.app.model.AccountEntity;
import com.app.util.CollectionUtil;

@Repository
public class AccountEntityDaoImpl implements IAccountEntityDao{

	@Autowired
	private HibernateTemplate ht;

	public String saveAccountEntity(AccountEntity accountNumber) {
		// TODO Auto-generated method stub
		return (String) ht.save(accountNumber);
	}
	public List<AccountEntity> getAllAccounts() {
		// TODO Auto-generated method stub
		return ht.loadAll(AccountEntity.class);
	}
	@Override
	public AccountEntity getOneAccount(String accountNumber) {
		// TODO Auto-generated method stub
		return ht.get(AccountEntity.class, accountNumber);
	}
	@Override
	public void updateAccount(AccountEntity ae) {
		// TODO Auto-generated method stub
		ht.update(ae);
	}

	@Override
	public boolean isAccountNumberExist(String accountNumber) {
		long count=0;
		//	String hql="select count(accountNumber) from "+AccountEntity.class.getName()+" where AccountEntity = ?0";
		DetachedCriteria hql=
				DetachedCriteria.forClass(AccountEntity.class)
				.setProjection(Projections.count("accountNumber"))
				.add(Restrictions.eq("accountNumber", accountNumber))
				;

		@SuppressWarnings("unchecked")
		List<Long> list = (List<Long>)ht.findByCriteria(hql);
		if(list!=null&&!list.isEmpty()) {
			count=list.get(0);
		}
		return count>0?true:false;	

	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean isIFCCodeExist(String IFCCode) {
		long count=0;
		DetachedCriteria hql=DetachedCriteria.forClass(AccountEntity.class).setProjection(Projections.count(IFCCode))
				.add(Restrictions.eq(IFCCode, IFCCode));
		List<Long> list=(List<Long>) ht.findByCriteria(hql);
		count=list.get(0);
		return count>0?true:false;
	}
	@Override
	public List<AccountEntity> getAllAccountsStatus() {
		DetachedCriteria criteria = DetachedCriteria.forClass(AccountEntity.class)
		.setProjection(Projections.projectionList()
		.add(Projections.property("holderName")).add(Projections.property("accountType")));
		@SuppressWarnings("unchecked")
		List<AccountEntity> all = (List<AccountEntity>) ht.findByCriteria(criteria);
		return all;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, List<String>> checkAccountType(String accountType) {
		DetachedCriteria criteria = DetachedCriteria.forClass(AccountEntity.class)
				.setProjection(Projections.projectionList()
						.add(Projections.property("accountType"))
						.add(Projections.property("holderName"))
						).add(Restrictions.eq("accountType", accountType));
		return CollectionUtil.toMap((List<Object[]>) ht.findByCriteria(criteria));
	}
}
