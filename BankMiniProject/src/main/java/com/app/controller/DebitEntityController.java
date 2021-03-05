package com.app.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.AccountActivities;
import com.app.model.DebitEntity;
import com.app.model.TransactionsEntity;
import com.app.service.IAcActivitiesService;
import com.app.service.IDebitEntityService;
import com.app.service.ITransactionaService;
import com.app.validator.DebitEntityValidaor;

@Controller
@RequestMapping("/debitform")
public class DebitEntityController {

	@Autowired
	private IDebitEntityService service;
	@Autowired
	private IAcActivitiesService aservice;
	@Autowired
	private DebitEntityValidaor validator;
	
	@Autowired
	private ITransactionaService tservice;

	@RequestMapping("show")
	public String showDebitForm(ModelMap map) {
		map.addAttribute("debitEntity", new DebitEntity());
		return "DebitForm";
	}

	@RequestMapping(value="/debit",method = RequestMethod.POST)
	public String createAccount(@ModelAttribute DebitEntity debitEntity,ModelMap map,Errors errors) {
		debitEntity.setDebitDate(new Date());
		Double debitAmount = debitEntity.getDebitAmount();
		String debitType = debitEntity.getDebitType();

		AccountActivities to = aservice.getOneAc(debitEntity.getDebitAccountNo());
		AccountActivities from = aservice.getOneAc(debitEntity.getFromAccount());
		Double amount = debitEntity.getDebitAmount(); 

		validator.validate(debitEntity, errors);

		if(!errors.hasErrors() && debitType.equals("ToCash")) {
			AccountActivities oneAc = aservice.getOneAc(debitEntity.getDebitAccountNo());
			Double accountAmount = oneAc.getAmount()+debitAmount;
			oneAc.setAmount(accountAmount);
			aservice.updateAmount(oneAc);
			service.debitAmount(debitEntity);
			
			TransactionsEntity t = new TransactionsEntity();
			t.setRefNumber(debitEntity.getReferenceNo());
			t.setAccountNo(oneAc.getAcNo());
			t.setName(oneAc.getHdName());
			t.setDate(new Date());
			t.setAmount(debitEntity.getDebitAmount());
			String st="debit";
			t.setType(st);
			tservice.saveTransaction(t);
			
			String message= debitEntity.getDebitAmount()+ " Rs. debited succesfully to " + oneAc.getAcNo();
			map.addAttribute("msg",message );
			map.addAttribute("debitEntity", new DebitEntity());
		}
		else if(!errors.hasErrors() && debitType.equals("ToAccount") && !(amount>from.getAmount())) {
		service.debitAmount(debitEntity); 
		Double amt=from.getAmount()-debitEntity.getDebitAmount(); 
		from.setAmount(amt);
		aservice.updateAmount(from); 
		
		TransactionsEntity t = new TransactionsEntity();
		t.setRefNumber(debitEntity.getReferenceNo());
		t.setAccountNo(debitEntity.getDebitAccountNo());
		t.setName(to.getHdName());
		t.setDate(new Date());
		t.setAmount(debitEntity.getDebitAmount());
		String st="debit";
		t.setType(st);
		tservice.saveTransaction(t);
		
		String message= debitEntity.getDebitAmount()+" Rs. debited succesfully to " + to.getAcNo(); 
		map.addAttribute("msg",message );
		map.addAttribute("debitEntity", new DebitEntity()); 
		}
		else if(amount>from.getAmount()) {
			return "AmountNotFound"; 
		}
		else {
			map.addAttribute("msg", "Please check all erros!!....");
	}

	return "DebitForm";
}
}
