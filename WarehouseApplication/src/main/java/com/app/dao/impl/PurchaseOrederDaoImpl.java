package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;

@Repository
public class PurchaseOrederDaoImpl implements IPurchaseOrderDao {
	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer savePurchaseOrder(PurchaseOrder po) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(po);
	}

	@Override
	public void updatePurchaseOrder(PurchaseOrder po) {
		// TODO Auto-generated method stub
		ht.update(po);
	}

	@Override
	public void deletePurchaseOrder(Integer id) {
		// TODO Auto-generated method stub
		PurchaseOrder p=new PurchaseOrder();
		p.setId(id);
		ht.delete(p);
	}

	@Override
	public PurchaseOrder getOnePurchaseOrder(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(PurchaseOrder.class, id);
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrders() {
		// TODO Auto-generated method stub
		return ht.loadAll(PurchaseOrder.class);
	}

}
