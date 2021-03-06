package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomTypeDao;
import com.app.model.UomType;
@Repository
public class UomTypeDaoImpl implements IUomTypeDao {
	
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveUomType(UomType ut) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(ut);
	}

	@Override
	public void updateUomType(UomType ut) {
		// TODO Auto-generated method stub
		ht.update(ut);
	}

	@Override
	public void deleteUomType(Integer id) {
		// TODO Auto-generated method stub
		UomType u=new UomType();
		u.setId(id);
		ht.delete(u);
	}

	@Override
	public UomType getOneUomType(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(UomType.class, id);
	}

	@Override
	public List<UomType> getAllUomTypes() {
		// TODO Auto-generated method stub
		return ht.loadAll(UomType.class);
	}
	@Override
	public boolean isUomModelExist(String uomModel) {
		// TODO Auto-generated method stub
		long count=0;
		String hql="select count(uomModel)"
					+ "from com.app.modelUomType"
					+ "where uomModel=?0";
		List<Long> list=(List<Long>) ht.find(hql, uomModel);
		if(list!=null && !list.isEmpty()) {
			count=list.get(0);
		}
		return count!=0?true:false;
	}

}
