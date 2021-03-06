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

import com.app.model.ShipmentType;
import com.app.model.UomType;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.view.ShipmentTypeExcelView;
import com.app.view.ShipmentTypePdfView;
import com.app.view.UomTypeExcelView;
import com.app.view.WhUserTypeExcelView;
import com.app.view.WhUserTypePdfView;

@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {
	
	@Autowired
	private IWhUserTypeService service;
	
	@RequestMapping("/show")
	public String showPage(ModelMap map) {
		map.addAttribute("whUserType", new WhUserType());
		return "WhUserTypeReg";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveWhUserType(@ModelAttribute WhUserType whUserType,ModelMap map) {
		Integer id=service.saveWhUserType(whUserType);
		String message="WhUserType '"+id+"' is Succsfiully saved";
		map.addAttribute("whUserType", new WhUserType());
		map.addAttribute("msg",message);
		return "WhUserTypeReg";
	}
	@RequestMapping("/all")
	public String getAllWhUserTypes(ModelMap map) {
		List<WhUserType> ob=service.getAllWhUserTypes();
		map.addAttribute("list", ob);
		return "WhUserTypeData";
	}
	//delete one row based on primary key
		@RequestMapping("/delete")
		public String deleteWhUserType(@RequestParam Integer id,ModelMap map) {
			service.deleteWhUserType(id);
			List<WhUserType> ob=service.getAllWhUserTypes();
			map.addAttribute("list",ob);
			//map.addAttribute("msg","Item '"+id+"' deleted succesfully");
			String message="WhUser '" +id+ "' is deleted succesfully";
			map.addAttribute("msg", message);
			return "WhUserTypeData";
			
		}
		@RequestMapping("/edit")
		public String EditWhUser(@RequestParam Integer id,ModelMap map) {
			WhUserType w=service.getOneWhUserType(id);
			map.addAttribute("whUserType", w);
			return "WhUserTypeEdit";
		}
		@RequestMapping(value="/update",method=RequestMethod.POST)
		public String updateWhUserType(@ModelAttribute WhUserType whUserType,ModelMap map) {
			service.updateWhUserType(whUserType);
			List<WhUserType> ob=service.getAllWhUserTypes();
			map.addAttribute("list", ob);
			String message="WhUser is update succesfully";
			map.addAttribute("msg", message);
			return "WhUserTypeEdit";
		}
		//get one row based on primary key
		@RequestMapping("/view")
		public String viewOne(@RequestParam Integer id,ModelMap map) {
			WhUserType w=service.getOneWhUserType(id);
			map.addAttribute("ob", w);
			return "WhUserTypeViewOne";
		}
		//Export Excel
		@RequestMapping("/excel")
		public ModelAndView showExcel() {
			List<WhUserType> ob=service.getAllWhUserTypes();
			ModelAndView m = new ModelAndView();
			m.setView(new WhUserTypeExcelView());
			m.addObject("list", ob);
			return m;
		}    
		//pdf Export
		@RequestMapping("/pdf")
		public ModelAndView showPdf(@RequestParam (value="id",required=false)Integer id) {
			ModelAndView m = new ModelAndView();
			m.setView(new WhUserTypePdfView());
			if(id!=null) {
				WhUserType w=service.getOneWhUserType(id);
				m.addObject("list", Arrays.asList(w));
			}
			else {
			List<WhUserType> ob=service.getAllWhUserTypes();
				m.addObject("list", ob);
			}
			return m;
		}
}