package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.UomType;
import com.app.service.IUomTypeService;
import com.app.validator.UomTypeValidator;
import com.app.view.UomTypeExcelView;
import com.app.view.UomTypePdfView;

@Controller
@RequestMapping("/uom")
public class UomTypeController {
	 
	@Autowired
	private IUomTypeService service;
	
	@Autowired
	private UomTypeValidator validator;
	
	@RequestMapping("/reg")
	public String showPage(ModelMap map) {
		map.addAttribute("uomType", new UomType());
		return "UomTypeRegister";
		
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveUomType(@ModelAttribute UomType uomType,ModelMap map,Errors errors) {
		Integer id=service.saveUomType(uomType);
		String message="Uom '"+id+"' is Succsfiully saved";
		map.addAttribute("uomType", new UomType());
		map.addAttribute("msg",message);
		return "UomTypeRegister";
		
	}
	@RequestMapping("/all")
	public String getAllUomTypes(ModelMap map) {
		List<UomType> ob=service.getAllUomTypes();
		map.addAttribute("list",ob);
		return "UomData";
	}
	
	@RequestMapping("/delete")
	public String deleteUomType(@RequestParam Integer id,ModelMap map) {
		service.deleteUomType(id);
		List<UomType> ob=service.getAllUomTypes();
		map.addAttribute("list", ob);
		String message="UomType '"+id+"' is succfully deleted";
		map.addAttribute("msg", message);
		return "UomData";
	}
	//show edit page
		@RequestMapping("/edit")
		public String showEdit(@RequestParam Integer id,ModelMap map) {
			UomType u=service.getOneUomType(id);
			map.addAttribute("uomType", u);
			return "UomTypeEdit";
		}
		//do update
		@RequestMapping(value="/update",method=RequestMethod.POST)
		public String doUpdate(@ModelAttribute UomType uomType,ModelMap map) {
			service.updateUomType(uomType);
			List<UomType> ob=service.getAllUomTypes();
		//	String message="UouType '"+id+"' is updaated succesfull";
			map.addAttribute("list", ob);
			map.addAttribute("msg","UomType '"+uomType.getId()+"' is Updated");
			return "UomData";
		}
		//get one row based on primary key
		@RequestMapping("/view")
		public String viewOne(@RequestParam Integer id,ModelMap map) {
			UomType u=service.getOneUomType(id);
			map.addAttribute("ob", u);
			return "UomTypeViewOne";
		} 
		//Export Excel
		@RequestMapping("/excel")
		public ModelAndView showExcel() {
			List<UomType> ob=service.getAllUomTypes();
			ModelAndView m = new ModelAndView();
			m.setView(new UomTypeExcelView());
			m.addObject("list", ob);
			return m;
		}    
		//pdf export
		@RequestMapping("/pdf")
		public ModelAndView showPdf(@RequestParam (value="id",required=false)Integer id) {
			ModelAndView m = new ModelAndView();
			m.setView(new UomTypePdfView());
			if(id!=null) {
				UomType s=service.getOneUomType(id);
				m.addObject("list", Arrays.asList(s));
			}
			else {
				List<UomType> ob=service.getAllUomTypes();
				m.addObject("list", ob);
			}
			return m;
}
}