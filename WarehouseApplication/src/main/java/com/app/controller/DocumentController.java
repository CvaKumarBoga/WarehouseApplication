package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
@RequestMapping("/docs")
public class DocumentController {
	
	@Autowired
	private IDocumentService service;
	
	//Show page
	@RequestMapping("/show")
	public String showDoc(ModelMap map) {
		List<Object[]> ob=service.getFileIdAndNames();
		map.addAttribute("list", ob);
		return "Documents";
	}
	//Upload document
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upoadDoc(@RequestParam CommonsMultipartFile fob) {
	//file converting in to model class object
		if(fob!=null) {
			Document doc=new Document();
			doc.setFileName(fob.getOriginalFilename());
			doc.setFileData(fob.getBytes());
			service.saveDocument(doc);
			System.out.println("Upload succesfully");
		}
		return "redirect:show";
	}  
}
