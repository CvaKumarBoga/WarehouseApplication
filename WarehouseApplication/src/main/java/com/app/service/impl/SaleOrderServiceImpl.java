package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ISaleOrderDao;
import com.app.model.SaleOrder;
import com.app.service.ISaleOrderService;
@Service
public class SaleOrderServiceImpl implements ISaleOrderService {
	@Autowired
	private ISaleOrderDao dao;

	@Override
	@Transactional
	public Integer saveSaleOrder(SaleOrder so) {
		// TODO Auto-generated method stub
		return dao.saveSaleOrder(so);
	}

	@Override
	@Transactional
	public void updateSaleOrder(SaleOrder so) {
		// TODO Auto-generated method stub
		dao.updateSaleOrder(so);
	}

	@Override
	@Transactional
	public void deleteSaleOrder(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteSaleOrder(id);
	}

	@Override
	@Transactional(readOnly=true
	)
	public SaleOrder getOneSaleOrder(Integer id) {
		// TODO Auto-generated method stub
		return dao.getOneSaleOrder(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<SaleOrder> getAllSaleOrders() {
		// TODO Auto-generated method stub
		return dao.getAllSaleOrders();
	}
	
	
}