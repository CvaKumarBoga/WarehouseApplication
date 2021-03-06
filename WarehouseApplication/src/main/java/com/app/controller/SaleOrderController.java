package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.SaleOrder;
import com.app.model.ShipmentType;
import com.app.model.WhUserType;
import com.app.service.ISaleOrderService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;


@Controller
@RequestMapping("/saleorder")
public class SaleOrderController {
	
	@Autowired
	private ISaleOrderService service;
	@Autowired
	private IShipmentTypeService shipSerice;
	@Autowired
	private IWhUserTypeService whService;

	
	@RequestMapping("/reg")
	public String showPage(ModelMap map) {
		map.addAttribute("saleOrder", new SaleOrder());
		List<ShipmentType> stob=shipSerice.getAllShipmentTypes();
		map.addAttribute("stob", stob);
		List<WhUserType> whob=whService.getAllWhUserTypes();
		map.addAttribute("whob", whob);
		return "SaleOrderReg";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveSaleOrder(@ModelAttribute SaleOrder saleOrder,ModelMap map) {
		Integer id=service.saveSaleOrder(saleOrder);
		String message="saleOrder '" +id+ "' saved succesfully";
		map.addAttribute("saleOrder", new SaleOrder());
		map.addAttribute("msg", message);
		List<ShipmentType> stob=shipSerice.getAllShipmentTypes();
		map.addAttribute("stob", stob);
		List<WhUserType> whob=whService.getAllWhUserTypes();
		map.addAttribute("whob", whob);
		return "SaleOrderReg";
	}
	//fetch all rows from DB and send to UI
	@RequestMapping("/all")
	public String getAllSaleOrder(ModelMap map) {
		List<SaleOrder> ob=service.getAllSaleOrders();
		map.addAttribute("list", ob);
		return "SaleOrderData";
	}
	//delete one row based on primary key
	@RequestMapping("/delete")
	public String deleteSaleOrder(@RequestParam Integer id,ModelMap map) {
		service.deleteSaleOrder(id);
		List<SaleOrder> ob=service.getAllSaleOrders();
		map.addAttribute("list",ob);
		//map.addAttribute("msg","Item '"+id+"' deleted succesfully");
		String message="saleOrder '" +id+ "' is deleted succesfully";
		map.addAttribute("msg", message);
		return "SaleOrderData";
		
	}
	//show edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam Integer id,ModelMap map) {
		SaleOrder s=service.getOneSaleOrder(id);
		map.addAttribute("saleOrder", s);
		List<ShipmentType> stob=shipSerice.getAllShipmentTypes();
		map.addAttribute("stob", stob);
		List<WhUserType> whob=whService.getAllWhUserTypes();
		map.addAttribute("whob", whob);
		return "SaleOrderEdit";
	}
	//do update
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String doUpdate(@ModelAttribute SaleOrder saleOrder,ModelMap map) {
		service.updateSaleOrder(saleOrder);
		List<SaleOrder> ob=service.getAllSaleOrders();
		map.addAttribute("list", ob);
		map.addAttribute("msg","saleOrder is Updated");
		return "SaleOrderEdit";
	}
	//get one row based on primary key
	@RequestMapping("/view")
	public String viewOne(@RequestParam Integer id,ModelMap map) {
		SaleOrder s=service.getOneSaleOrder(id);
		map.addAttribute("ob", s);
		return "SaleOrderViewOne";
	}
}
