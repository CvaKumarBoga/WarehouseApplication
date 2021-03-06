package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;

@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {
	
	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveOrderMethod(OrderMethod om) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(om);
	}

	@Override
	public void updateOrderMethod(OrderMethod om) {
		// TODO Auto-generated method stub
		ht.update(om);
	}

	@Override
	public void deleteOrderMethod(Integer id) {
		// TODO Auto-generated method stub
		OrderMethod o=new OrderMethod();
		o.setId(id);
		ht.delete(o);
	}

	@Override
	public OrderMethod getOneOrderMethod(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(OrderMethod.class, id);
	}

	@Override
	public List<OrderMethod> getAllOrderMethods() {
		// TODO Auto-generated method stub
		return ht.loadAll(OrderMethod.class);
	}

}
