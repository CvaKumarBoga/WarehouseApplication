package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.OrderMethod;
import com.app.model.ShipmentType;
import com.app.service.IOrderMethodService;
import com.app.view.OrderMethodExcelview;
import com.app.view.OrederMethodPdfView;
import com.app.view.ShipmentTypeExcelView;
import com.app.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/order")
public class OrderMethodController {
	
	@Autowired
	private IOrderMethodService service;
	
	@RequestMapping("/reg")
	public String showPage(ModelMap map) {
		map.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodReg";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveOrderMethod(@ModelAttribute OrderMethod orderMethod,ModelMap map) {
		Integer id=service.saveOrderMethod(orderMethod);
		String message="OrderMethod '"+id+"' is saved Succesfully";
		map.addAttribute("orderMethod",new OrderMethod());
		map.addAttribute("msg", message);
		return "OrderMethodReg";
	}
	@RequestMapping("/all")
	public String getAllOrderMethods(ModelMap map) {
	List<OrderMethod> ob=service.getAllOrderMethods();
	map.addAttribute("list", ob);
	return "OrderMethodData";
	}
	@RequestMapping("/delete")
	public String deleteOrderMethod(@RequestParam Integer id,ModelMap map) {
		service.deleteOrderMethod(id);
		List<OrderMethod> ob=service.getAllOrderMethods();
		String message="OrderMethd '"+id+"' is deleted succesfully";
		map.addAttribute("list",ob);
		map.addAttribute("msg", message);
		return "OrderMethodData";
	}
	@RequestMapping("/edit")
	public String editPage(@RequestParam Integer id,ModelMap map) {
		OrderMethod o=service.getOneOrderMethod(id);
		map.addAttribute("orderMethod", o);
		return "OrderMethodEdit";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateOrderMethod(@ModelAttribute OrderMethod orderMethod,ModelMap map) {
		service.updateOrderMethod(orderMethod);
		List<OrderMethod> ob=service.getAllOrderMethods();
		map.addAttribute("list", ob);
		map.addAttribute("msg", "OrderMethod is Updatd succsfully");
		return "OrderMethodData";
	} 
	//get one row based on primary key
		@RequestMapping("/view")
		public String viewOne(@RequestParam Integer id,ModelMap map) {
			OrderMethod o=service.getOneOrderMethod(id);
			map.addAttribute("ob", o);
			return "OrderMethodViewOne";
		}
		//Export Excel
		@RequestMapping("/excel")
		public ModelAndView showExcel() {
			List<OrderMethod> ob=service.getAllOrderMethods();
			ModelAndView m = new ModelAndView();
			m.setView(new OrderMethodExcelview());
			m.addObject("list", ob);
			return m;
		}    
		//pdf Export
		@RequestMapping("/pdf")
		public ModelAndView showPdf(@RequestParam (value="id",required=false)Integer id) {
			ModelAndView m = new ModelAndView();
			m.setView(new OrederMethodPdfView());
			if(id!=null) {
				OrderMethod o=service.getOneOrderMethod(id);
				m.addObject("list", Arrays.asList(o));
			}
			else {
				List<OrderMethod> ob=service.getAllOrderMethods();
				m.addObject("list", ob);
			}
			return m;
}
}