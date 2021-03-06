package com.app.dao;

import java.util.List;

import com.app.model.SaleOrder;

public interface ISaleOrderDao {
	public Integer saveSaleOrder(SaleOrder so);
	public void updateSaleOrder(SaleOrder so);
	public void deleteSaleOrder(Integer id);
	public SaleOrder getOneSaleOrder(Integer id);
	public List<SaleOrder> getAllSaleOrders();
}
