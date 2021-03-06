package com.app.service;

import java.util.List;

import com.app.model.PurchaseOrder;

public interface IPurchaseOrederService {
	
	public Integer savePurchaseOrder(PurchaseOrder po);
	public void updatePurchaseOrder(PurchaseOrder po);
	public void deletePurchaseOrder(Integer id);
	public PurchaseOrder getOnePurchaseOrder(Integer id);
	public List<PurchaseOrder> getAllPurchaseOrders();
}
