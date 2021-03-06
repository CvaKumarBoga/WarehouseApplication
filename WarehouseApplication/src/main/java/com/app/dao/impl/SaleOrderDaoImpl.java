package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ISaleOrderDao;
import com.app.model.SaleOrder;
@Repository
public class SaleOrderDaoImpl implements ISaleOrderDao {
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveSaleOrder(SaleOrder so) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(so);
	}

	@Override
	public void updateSaleOrder(SaleOrder so) {
		// TODO Auto-generated method stub
		ht.update(so);
	}

	@Override
	public void deleteSaleOrder(Integer id) {
		// TODO Auto-generated method stub
		SaleOrder o=new SaleOrder();
		o.setId(id);
		ht.delete(o);
	}

	@Override
	public SaleOrder getOneSaleOrder(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(SaleOrder.class, id);
	}

	@Override
	public List<SaleOrder> getAllSaleOrders() {
		// TODO Auto-generated method stub
		return ht.loadAll(SaleOrder.class);
	}

}
