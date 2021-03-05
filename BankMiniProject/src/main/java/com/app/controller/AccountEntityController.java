package com.app.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.advicecontroller.AccountNumberNotFoundException;
import com.app.model.AccountEntity;
import com.app.model.RegistrationEntity;
import com.app.pdfview.AccountEntityPdfView;
import com.app.service.IAccountEntityService;
import com.app.service.IRegistrationEntityService;
import com.app.util.EmailUtil;
import com.app.validator.AccountEntityValidator;

@Controller
@RequestMapping("account")
public class AccountEntityController {

	@Autowired
	private IAccountEntityService service;

	@Autowired
	private AccountEntityValidator validator;

	@Autowired
	private IRegistrationEntityService rservice;
	
	@Autowired
	private AccountEntityPdfView pdf;

	@Autowired
	private EmailUtil emailUtil;

	@RequestMapping("show")
	public String showPage(ModelMap map) {
		map.addAttribute("accountEntity", new AccountEntity());
		return "AccountForm";
	}
	//Get all requested applications
	@RequestMapping("getregistrations")
	public String getAllData(ModelMap map) {
		List<Object[]> applicants = rservice.getApplicants();
		map.addAttribute("list", applicants);
		return "AllRegistrationsData";
	}

	@RequestMapping("/getphoto/{id}")
	public String getPhoto(HttpServletResponse res,@PathVariable("id") Integer id) throws SQLException, IOException {
		RegistrationEntity one = rservice.getOne(id);
		byte[] photo = one.getPhoto();
		res.setContentType("image/jpg");
		try {
			FileCopyUtils.copy(one.getPhoto(),res.getOutputStream());
		} catch (IOException e) {

			e.printStackTrace();
		}
		return  null;
	}

	@RequestMapping("/getone")
	public String getOneForm(@RequestParam Integer id,ModelMap map) {
		RegistrationEntity one = rservice.getOne(id);
		map.addAttribute("obj", one);
		return "AccountForm";
	}

	@RequestMapping(value="/create",method = RequestMethod.POST)
	public String createAccount(@ModelAttribute AccountEntity accountEntity,ModelMap map,Errors errors)  {
		String str="APPROVE STATE";
		//check validator
		validator.validate(accountEntity, errors);
		//check for exist
		if(!errors.hasErrors()) {	//no errors
			//RegistrationEntity update	
			RegistrationEntity one = rservice.getOne(accountEntity.getSerialNo());
			String status = one.getStatus();
			one.setStatus(str);
			rservice.updateRegistration(one);
			String account = service.saveAccountEntity(accountEntity);
			
			/*
			 * AccountEntity oneAccount = service.getOneAccount(account);
			 * List<AccountEntity> asList = Arrays.asList(oneAccount);
			 * 
			 * FileSystemResource file = new FileSystemResource(new File());
			 */
			
			
			
			String message="Account created succesfully";
			map.addAttribute("accountEntity", new AccountEntity());

			//email config start
			String text="Hello! " + accountEntity.getHolderName() 
			+ ",\nWelcome to State Bank of India. Your account is created succesfully."
			+ " Please check your status by using below Registration number and account number."
			+ "\nAccount No: "+accountEntity.getAccountNumber()
			+ "\nRegistration No: "+accountEntity.getSerialNo()
			+ " \nThanking You!..";

			boolean flag=emailUtil.sendEmail(accountEntity.getHolderEmail() , "Welcome!!..", text);
			if(flag)
				message+=", Email sending is failed!!";
			else
				message+=", Email also sent!!";

			map.addAttribute("msg", message);
			map.addAttribute("msg",message );
		}else {
			map.addAttribute("msg", "Please check all errors");
		}
		return "redirect:/activities/show";
	}

	@RequestMapping("/all")
	public String getAllAccounts(ModelMap map) {
		List<AccountEntity> allAccounts = service.getAllAccounts();
		//fetch the data in sorted order based on amount
		//	allAccounts.sort((a,b)->a.getAmount().compareTo(b.getAmount()));
		map.addAttribute("list", allAccounts);
		return "AllAccounts";
	}
	@RequestMapping("/accountsearch")
	public String showViewOne(@RequestParam(value = "accountNumber",required = false) String accountNumber,Model map) {
		return "GetOneAccount";
	}
	@RequestMapping("/viewone")
	public String getOneAccount(@RequestParam(value = "accountNumber",required = false) String accountNumber,Model map) throws AccountNumberNotFoundException {
		AccountEntity oneAccount = service.getOneAccount(accountNumber);
		if(oneAccount!=null) {
			map.addAttribute("obj", oneAccount);
			return "ViewOneAccount";	
		}
		else {
			throw new AccountNumberNotFoundException();
		}	
	}
	@ExceptionHandler(AccountNumberNotFoundException.class)
	public String InvalidAccountEx() {
		return "AccountNotFound";
	}

	@RequestMapping("/accountpdf")
	public ModelAndView showPdf(@RequestParam(value = "accountNumber",required = false)String number) {
		ModelAndView view = new ModelAndView();
		view.setView(new AccountEntityPdfView());
		if(number!=null) {
			AccountEntity oneAccount = service.getOneAccount(number);
			view.addObject("list", Arrays.asList(oneAccount));

		}else {
			List<AccountEntity> accounts = service.getAllAccounts();
			view.addObject("list", accounts);
		}
		return view;
	}
	@RequestMapping("/accounttype")
	public String showAccoutType(ModelMap map) {
		map.addAttribute("accountType", new AccountEntity());
		return "AccountType";
	}
	@RequestMapping(value = "/type",method = RequestMethod.POST)
	public String checkAccountType(@RequestParam String accountType,ModelMap map) {
		
		List<AccountEntity> list = service.getAllAccountsStatus();
		map.addAttribute("list",list);
		return "AccountType";
	}

	@RequestMapping("/menubar")
	public String updateStatus(ModelMap map) {
		return "Menubarjsp";
	}
	@RequestMapping("construction")
	public String under() {
		return "UnderConstruction";
	}
}

