package com.app.service;

import java.util.List;

import com.app.model.SaleOrder;

public interface ISaleOrderService {
	public Integer saveSaleOrder(SaleOrder so);
	public void updateSaleOrder(SaleOrder so);
	public void deleteSaleOrder(Integer id);
	public SaleOrder getOneSaleOrder(Integer id);
	public List<SaleOrder> getAllSaleOrders();
}
