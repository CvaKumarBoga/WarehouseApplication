package com.app.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.AccountEntity;
import com.app.model.RegistrationEntity;
import com.app.pdfview.AccountEntityPdfView;
import com.app.service.IAccountEntityService;
import com.app.service.IRegistrationEntityService;

@Controller
@RequestMapping("/registration")
public class RegistrationEntityController {

	@Autowired
	private IRegistrationEntityService service;
	@Autowired
	private IAccountEntityService aservice;

	@RequestMapping("/show")
	public String showForm(ModelMap map) {
		map.addAttribute("registrationEntity",new RegistrationEntity());
		return "Registration";
	}
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	//public String saveRegForm(@ModelAttribute RegistrationEntity registrationEntity,ModelMap map) {
	public String saveRegForm(@RequestParam("name") String name,
			@RequestParam CommonsMultipartFile fob,
			@RequestParam("emailId") String email,
			@RequestParam("phoneNo") String phone,
			@RequestParam("dob") String dofb,
			@RequestParam("address") String addr,ModelMap map
			) throws Exception {
		if(fob!=null) {
			RegistrationEntity res = new RegistrationEntity();
			String str="REQUEST STATE";
			res.setName(name);
			res.setPhotoName(fob.getOriginalFilename().toLowerCase());
			byte[] bytes = fob.getBytes();
			res.setPhoto(bytes);
			res.setEmailId(email);
			res.setPhoneNo(Long.parseLong(phone));
			res.setDob(dofb);
			res.setAddress(addr);
			res.setStatus(str);

			service.saveRegistr(res);
			String message="Application submited succesfully!!...";
			map.addAttribute("registrationEntity",new RegistrationEntity());
			map.addAttribute("msg", message);
		}
		return "Registration";
	}
	@RequestMapping("checkstatus")
	public String checkStatus(ModelMap map) {
		return "CheckRegStatus";
	}
	
	@RequestMapping("/getone")
	public String getOneForm(@RequestParam Integer id, @RequestParam Long phoneNo, ModelMap map) {
		RegistrationEntity one = service.getOne(id);
		map.addAttribute("obj", one);
		return "CheckRegStatus";
	}
	@RequestMapping("/getphoto/{id}")
	public String getPhoto(HttpServletResponse res,@PathVariable("id") Integer id) throws SQLException, IOException {
		RegistrationEntity one = service.getOne(id);
		byte[] photo = one.getPhoto();
		res.setContentType("image/jpg");
		try {
			FileCopyUtils.copy(one.getPhoto(),res.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  null;
	}
	@RequestMapping("/edit")
	public String EditRegForm() {
		return "EditRegistration";
	}
	@RequestMapping(value = "editpage",method = RequestMethod.POST)
	public String EditRegForm(@RequestParam Integer id, @RequestParam Long phoneNo, ModelMap map) {
		RegistrationEntity one = service.getOne(id);
		map.addAttribute("obj", one);
		return "UpdateRegistration";
	}
	@RequestMapping("/update")
	public String editRegistration(@ModelAttribute RegistrationEntity registrationEntity, ModelMap map) {
		service.updateRegistration(registrationEntity);
		map.addAttribute("registrationEntity", new RegistrationEntity());
		return "home";
	}	
	@RequestMapping("check")
	public String showCheckForm() {
		return "CheckAccountDetails";
	}
	
	@RequestMapping("/accountpdf")
	public ModelAndView CheckDetails(@RequestParam Integer serialNo, @RequestParam String accountNumber, ModelMap map) {
		ModelAndView view = new ModelAndView();
		view.setView(new AccountEntityPdfView());
		if(accountNumber!=null) {
			AccountEntity oneAccount = aservice.getOneAccount(accountNumber);
			view.addObject("list", Arrays.asList(oneAccount));
		}else {
			
		}
		return view;
	}
	
	@RequestMapping("/home")
	public String home(ModelMap map) {
		return "Home";
	}
	@RequestMapping("/construction")
	public String construction() {
		return "UnderConstruction";
	}
}
