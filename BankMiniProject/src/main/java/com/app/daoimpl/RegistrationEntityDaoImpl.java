package com.app.daoimpl;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.app.dao.IRegistrationEntityDao;
import com.app.model.RegistrationEntity;
@Repository
public class RegistrationEntityDaoImpl implements IRegistrationEntityDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveRegistr(RegistrationEntity reg) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(reg);
	}
	@Override
	public RegistrationEntity getOne(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(RegistrationEntity.class, id);
	}
	@Override
	public void updateRegistration(RegistrationEntity reg) {
		 ht.update(reg);
	}
	@Override
	public List<RegistrationEntity> getAllForms() {
		// TODO Auto-generated method stub
		return ht.loadAll(RegistrationEntity.class);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getApplicants() {
		/*
		 * // TODO Auto-generated method stub String
		 * hql=" select regId,name,emailId,phoneNo,photoName,photo " +
		 * " from com.app.model.RegistrationEntity ";
		 * 
		 * @SuppressWarnings("deprecation") List<Object[]>
		 * list=(List<Object[]>)ht.find(hql);
		 */
		DetachedCriteria hql = DetachedCriteria.forClass(RegistrationEntity.class)
				.setProjection(Projections
						.projectionList()
						.add(Projections.property("id"))
						.add(Projections.property("name"))
						.add(Projections.property("emailId"))
						.add(Projections.property("phoneNo"))
						.add(Projections.property("photoName"))
						.add(Projections.property("status"))
						);
		List<Object[]> list = (List<Object[]>) ht.findByCriteria(hql);
		return list;
	}
}
