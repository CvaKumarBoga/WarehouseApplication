package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;


@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {
	
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveShipmentType(ShipmentType st) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(st);
	}

	@Override
	public void updateShipmentType(ShipmentType st) {
		// TODO Auto-generated method stub
		ht.update(st);

	}

	@Override
	public void deleteShipmentType(Integer id) {
		// TODO Auto-generated method stub
		ShipmentType s=new ShipmentType();
		s.setId(id);
		ht.delete(s);
	}

	@Override
	public ShipmentType getOneShipmentType(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(ShipmentType.class, id);
	}

	@Override
	public List<ShipmentType> getAllShipmentTypes() {
		// TODO Auto-generated method stub
		return ht.loadAll(ShipmentType.class);
	}

	@Override
	public List<Object[]> getShipmentsModeCount() {
		// TODO Auto-generated method stub
		String hql=" select shipmentMode ,count(shipmentMode) "
				   + " from com.app.model.ShipmentType "
				   + " group by shipmentMode ";
		List<Object[]> list=(List<Object[]>) ht.find(hql);
		return list;
	}

}
