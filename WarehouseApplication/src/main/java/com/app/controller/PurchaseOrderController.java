package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.PurchaseOrder;
import com.app.model.ShipmentType;
import com.app.model.WhUserType;
import com.app.service.IPurchaseOrederService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;


@Controller
@RequestMapping("/purchase")
public class PurchaseOrderController {
	
	@Autowired
	private IPurchaseOrederService service;
	@Autowired
	private IShipmentTypeService shipmentService;
	@Autowired
	private IWhUserTypeService whService;
	
	@RequestMapping("/reg")
	public String showPage(ModelMap map) {
		map.addAttribute("purchaseOrder", new PurchaseOrder());
		List<ShipmentType> shob=shipmentService.getAllShipmentTypes();
		map.addAttribute("shob", shob);
		List<WhUserType> whob=whService.getAllWhUserTypes();
		map.addAttribute("whob", whob);
		return "PurchaseOrderReg";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveOrder(@ModelAttribute PurchaseOrder purchaseOrder,ModelMap map) {
		Integer id=service.savePurchaseOrder(purchaseOrder);
		String mesage="PurchaseOrder '"+id+"' is Saved Succesfully";
		map.addAttribute("purchaseOrder", new PurchaseOrder());
		map.addAttribute("msg", mesage);
		List<ShipmentType> shob=shipmentService.getAllShipmentTypes();
		map.addAttribute("shob", shob);
		List<WhUserType> whob=whService.getAllWhUserTypes();
		map.addAttribute("whob", whob);
		return "PurchaseOrderReg";
	}
	@RequestMapping("/all")
	public String viewData(ModelMap map) {
		List<PurchaseOrder> ob=service.getAllPurchaseOrders();
		map.addAttribute("list", ob);
		return "PurchaseOrderData";
	}
	@RequestMapping("/delete")
	public String deleteOrder(@RequestParam Integer id,ModelMap map) {
		service.deletePurchaseOrder(id);
		List<PurchaseOrder> ob=service.getAllPurchaseOrders();
		map.addAttribute("list", ob);
		String massage="PurchaseOrder '"+id+"' is deleted succesfilly";
		map.addAttribute("msg", massage);
		return "PurchaseOrderData";
	}
	@RequestMapping("/edit")
	public String editPage(@RequestParam Integer id,ModelMap map) {
		PurchaseOrder ob=service.getOnePurchaseOrder(id);
		map.addAttribute("purchaseOrder", ob);
		List<ShipmentType> shob=shipmentService.getAllShipmentTypes();
		map.addAttribute("shob", shob);
		List<WhUserType> whob=whService.getAllWhUserTypes();
		map.addAttribute("whob", whob);
		return "PurchaseOrderEdit";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updatePurchaseOrder(@ModelAttribute PurchaseOrder purchaseOrder,ModelMap map) {
		service.updatePurchaseOrder(purchaseOrder);
		List<PurchaseOrder> ob=service.getAllPurchaseOrders();
		map.addAttribute("list", ob);
		return "PurchaseOrderReg";
	}
}
