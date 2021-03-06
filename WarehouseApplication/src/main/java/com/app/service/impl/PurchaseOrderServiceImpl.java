package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;
import com.app.service.IPurchaseOrederService;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrederService {
	
	@Autowired
	private IPurchaseOrderDao dao;

	@Override
	@Transactional
	public Integer savePurchaseOrder(PurchaseOrder po) {
		// TODO Auto-generated method stub
		return dao.savePurchaseOrder(po);
	}

	@Override
	@Transactional
	public void updatePurchaseOrder(PurchaseOrder po) {
		// TODO Auto-generated method stub
		dao.updatePurchaseOrder(po);
	}

	@Override
	@Transactional
	public void deletePurchaseOrder(Integer id) {
		// TODO Auto-generated method stub
		dao.deletePurchaseOrder(id);
	}

	@Override
	@Transactional(readOnly=true)
	public PurchaseOrder getOnePurchaseOrder(Integer id) {
		// TODO Auto-generated method stub
		return dao.getOnePurchaseOrder(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<PurchaseOrder> getAllPurchaseOrders() {
		// TODO Auto-generated method stub
		return dao.getAllPurchaseOrders();
	}
	
	

}
