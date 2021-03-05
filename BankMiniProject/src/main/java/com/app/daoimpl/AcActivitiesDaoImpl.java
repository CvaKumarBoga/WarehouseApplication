package com.app.daoimpl;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.app.dao.IAcActivitiesDao;
import com.app.model.AccountActivities;

@Repository
public class AcActivitiesDaoImpl implements IAcActivitiesDao{

	@Autowired
	private HibernateTemplate ht;
	@Override
	public String debitAmounnt(AccountActivities acno) {
		// TODO Auto-generated method stub
		return (String) ht.save(acno) ;
	}
	@Override
	public boolean isAccountNumberExist(String acNo) {
		long count=0;
		DetachedCriteria hql=
				DetachedCriteria.forClass(AccountActivities.class)
				.setProjection(Projections.count("acNo"))
				.add(Restrictions.eq("acNo", acNo))
				;

		@SuppressWarnings("unchecked")
		List<Long> list = (List<Long>)ht.findByCriteria(hql);
		if(list!=null&&!list.isEmpty()) {
			count=list.get(0);
		}
		return count>0?true:false;
	}
	@Override
	public AccountActivities getOneAc(String accountNo) {
		// TODO Auto-generated method stub
		return ht.get(AccountActivities.class, accountNo);
	}

	@Override
	public void updateAmount(AccountActivities amount) {
		// TODO Auto-generated method stub
		ht.update(amount);
	}
	@Override
	public List<AccountActivities> getall() {
		// TODO Auto-generated method stub
		return ht.loadAll(AccountActivities.class);
	}


}
