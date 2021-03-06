package com.app.controller;


import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
import com.app.util.ShipmentTypeUtil;
import com.app.view.ShipmentTypeExcelView;
import com.app.view.ShipmentTypePdfView;


@Controller
@RequestMapping("/stype")
public class ShipmentTypeController {
	
	@Autowired
	private IShipmentTypeService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private ShipmentTypeUtil util;
	//
	@RequestMapping("/reg")
	public String showPage(ModelMap map) {
		map.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
		
	}
	//
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveShipmentType(@ModelAttribute ShipmentType shipmentType,ModelMap map) {
		Integer id=service.saveShipmentType(shipmentType);
		String message="shipment '" +id+ "' saved succesfully";
		map.addAttribute("shipmentType", new ShipmentType());
		map.addAttribute("msg", message);
		return "ShipmentTypeRegister";
	}
	//fetch all rows from DB and send to UI
	@RequestMapping("/all")
	public String getAllShiments(ModelMap map) {
		List<ShipmentType> ob=service.getAllShipmentTypes();
		map.addAttribute("list", ob);
		return "ShipmentTypeData";
	}
	//delete one row based on primary key
	@RequestMapping("/delete")
	public String deleteShipmentType(@RequestParam Integer id,ModelMap map) {
		service.deleteShipmentType(id);
		List<ShipmentType> ob=service.getAllShipmentTypes();
		map.addAttribute("list",ob);
		//map.addAttribute("msg","Item '"+id+"' deleted succesfully");
		String message="shipment '" +id+ "' is deleted succesfully";
		map.addAttribute("msg", message);
		return "ShipmentTypeData";
		
	}
	//show edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam Integer id,ModelMap map) {
		ShipmentType s=service.getOneShipmentType(id);
		map.addAttribute("shipmentType", s);
		return "ShipmentTypeEdit";
	}
	//do update
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String doUpdate(@ModelAttribute ShipmentType shipmentType,ModelMap map) {
		service.updateShipmentType(shipmentType);
		List<ShipmentType> ob=service.getAllShipmentTypes();
		map.addAttribute("list", ob);
		map.addAttribute("msg","Shipment is Updated");
		return "ShipmentTypeEdit";
	}
	//get one row based on primary key
	@RequestMapping("/view")
	public String viewOne(@RequestParam Integer id,ModelMap map) {
		ShipmentType s=service.getOneShipmentType(id);
		map.addAttribute("ob", s);
		return "ShipmentTypeViewOne";
	}
	//Export Excel
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<ShipmentType> ob=service.getAllShipmentTypes();
		ModelAndView m = new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		m.addObject("list", ob);
		return m;
	}    
/*	//Special cases export one row or allrows
	@RequestMapping("/excel")
	public ModelAndView showRow(@RequestParam(value="id",required=false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		if(id!=null) {
			ShipmentType s=service.getOneShipmentType(id);
			m.addObject("list",Arrays.asList(s));
		}
		else {
			List<ShipmentType> ob=service.getAllShipmentTypes();
			m.addObject("list", ob);
		}
		return m;
	} */
	//pdf Export
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam (value="id",required=false)Integer id) {
		ModelAndView m = new ModelAndView();
		m.setView(new ShipmentTypePdfView());
		if(id!=null) {
			ShipmentType s=service.getOneShipmentType(id);
			m.addObject("list", Arrays.asList(s));
		}
		else {
			List<ShipmentType> ob=service.getAllShipmentTypes();
			m.addObject("list", ob);
		}
		return m;
	}
	//pichart code
	@RequestMapping("/charts")
	public String generateCharts() {
		String path=context.getRealPath("/");
		List<Object[]> list=service.getShipmentsModeCount();
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "ShipmentTypeCharts";
	}
	//Working with images

}
