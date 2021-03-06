package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Item;
import com.app.model.OrderMethod;
import com.app.model.UomType;
import com.app.service.IItemService;
import com.app.service.IOrderMethodService;
import com.app.service.IUomTypeService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private IItemService service;
	
	@Autowired
	private IUomTypeService uomService;
	
	@Autowired
	private IOrderMethodService ordService;
	
	@RequestMapping("/reg")
	public String showPage(ModelMap map) {
		map.addAttribute("item",new Item());
		List<UomType> uoms=uomService.getAllUomTypes();
		map.addAttribute("uoms", uoms);
		List<OrderMethod> oms=ordService.getAllOrderMethods();
		map.addAttribute("oms", oms);
		return "ItemRegister";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveItem(@ModelAttribute Item item,ModelMap map) {
		Integer id=service.saveItem(item);
		String message="Item '"+id+"' is Registried Succesfully";
		map.addAttribute("item",new Item());
		map.addAttribute("msg",message);
		List<UomType> uoms=uomService.getAllUomTypes();
		map.addAttribute("uoms", uoms);
		List<OrderMethod> oms=ordService.getAllOrderMethods();
		map.addAttribute("oms", oms);
		return "ItemRegister";
		
	}
	//fetch data from DB and display UI
	@RequestMapping("/all")
	public String getAllItems(ModelMap map) {
		List<Item> ob=service.getAllItems();
		map.addAttribute("list",ob);
		return "ItemData";
	}
	//delete row from DB
	@RequestMapping("/delete")
	public String deleteItem(@RequestParam Integer id,ModelMap map) {
		service.deleteItem(id);
		List<Item> ob=service.getAllItems();
		map.addAttribute("list", ob);
		map.addAttribute("msg","Item '"+id+"' deleted succesfully");
		return "ItemData";
	}
	//show edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam Integer id,ModelMap map) {
		Item it=service.getOneItem(id);
		map.addAttribute("item",it);
		List<UomType> uoms=uomService.getAllUomTypes();
		map.addAttribute("uoms", uoms);
		List<OrderMethod> oms=ordService.getAllOrderMethods();
		map.addAttribute("oms", oms);
		return "ItemEdit";
		
	}
	//do update
		@RequestMapping(value="/update",method=RequestMethod.POST)
		public String doUpdate(@ModelAttribute Item item,ModelMap map) {
			service.updateItem(item);
			List<Item> ob=service.getAllItems();
			map.addAttribute("list", ob);
			map.addAttribute("msg","Item  is Updated");
			return "ItemEdit";
		}
	@RequestMapping("/view")
	public String viewOne(@RequestParam Integer id,ModelMap map) {
		Item i=service.getOneItem(id);
		map.addAttribute("ob", i);
		return "ItemViewOne";
	}
}
		