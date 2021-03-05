package com.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.AccountActivities;
import com.app.service.IAcActivitiesService;
import com.app.validator.AccountActivitiesValidator;

@Controller
@RequestMapping("/activities")
public class AccountActivitiesController {

	@Autowired
	private IAcActivitiesService service;
	
	@Autowired
	private AccountActivitiesValidator validator;
	
	
	  @RequestMapping("/show") public String showFirstDebit(ModelMap map)
	  { map.addAttribute("accountActivities", new AccountActivities()); return
	  "FirstDeposit"; }
	 
	@RequestMapping(value = "/debit",method = RequestMethod.POST)
	public String firstDebit(@ModelAttribute AccountActivities accountActivities,ModelMap map,Errors errors) {
		accountActivities.setDate(new Date());
		
		validator.validate(accountActivities, errors);
		if(!errors.hasErrors()) {
		service.debitAmounnt(accountActivities);
		String msg="Amount debited succesfully";
		map.addAttribute("accountActivities", new AccountActivities());
		map.addAttribute("msg", msg);
		}else {
			map.addAttribute("msg","Please check errors!!....");
		}
		return "FirstDeposit";
	}
	@RequestMapping("all")
	public String getAllAccounts(ModelMap map) {
		List<AccountActivities> list = service.getall();
		map.addAttribute("list", list);
		return "GetAllAccounts";
	}
	@RequestMapping("/check")
	public String showCheckBalForm() {
		return "checkBalanceform";
	}
	@RequestMapping(value = "/checkbalance",method = RequestMethod.POST)
	public String checkBalance(@RequestParam String acNo,ModelMap map) {
		AccountActivities ac = service.getOneAc(acNo);
		map.addAttribute("ac", ac);
		return "checkBalanceform";
	}
	
}
