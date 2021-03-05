package com.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.AccountActivities;
import com.app.model.CreditEntity;
import com.app.model.TransactionsEntity;
import com.app.service.IAcActivitiesService;
import com.app.service.ICreditEntityService;
import com.app.service.ITransactionaService;

@Controller
@RequestMapping("/credit")
public class CreditEntityController {
	
	@Autowired
	private ICreditEntityService service;
	
	@Autowired
	private IAcActivitiesService aaservice;
	
	@Autowired
	private ITransactionaService tservice;
	
	@RequestMapping("show")
	public String showCreditPage(ModelMap map) {
		map.addAttribute("creditEntity", new CreditEntity());
		return "CreditForm";
	}
	@RequestMapping(value = "save",method = RequestMethod.POST)
	public String creditAmount(@ModelAttribute CreditEntity creditEntity,Model map,Errors errors) {
		creditEntity.setDate(new Date());
		//child operations
		Double amount = creditEntity.getAmount();
		AccountActivities oneAc = aaservice.getOneAc(creditEntity.getAcNo());
		Double finalAmount = oneAc.getAmount() - amount;
		oneAc.setAmount(finalAmount);
		aaservice.updateAmount(oneAc);
		
		service.creditAmount(creditEntity);
		
		TransactionsEntity t = new TransactionsEntity();
		t.setRefNumber(creditEntity.getRefNo());
		t.setAccountNo(creditEntity.getAcNo());
		t.setName(creditEntity.getName());
		t.setDate(new Date());
		t.setAmount(creditEntity.getAmount());
		String st="credit";
		t.setType(st);
		tservice.saveTransaction(t);
		map.addAttribute("msg", "Amount credited succesfully completed.");
		map.addAttribute("creditEntity", new CreditEntity());
		return "CreditForm";
	}

}
