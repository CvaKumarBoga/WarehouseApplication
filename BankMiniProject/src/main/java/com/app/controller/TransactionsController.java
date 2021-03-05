package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.AccountActivities;
import com.app.model.TransactionsEntity;
import com.app.service.IAcActivitiesService;
import com.app.service.ITransactionaService;
@RequestMapping("transaction")
@Controller
public class TransactionsController {

	@Autowired
	private ITransactionaService service;
	@Autowired
	private IAcActivitiesService aservice;

	@RequestMapping("all")
	public String getTrans(ModelMap map) {
		List<TransactionsEntity> list = service.getallTrans();
		map.addAttribute("list", list);
		List<AccountActivities> getall = aservice.getall();
		map.addAttribute("lst", getall);
		return "AllTransactions";
	}
	@RequestMapping("checktrans")
	public String getAcTransactions() {
		return "checkTransactions";
	}
	@RequestMapping(value = "check")
	public String checkAllTrans(@RequestParam String accountNo,ModelMap map) {
		List<TransactionsEntity> list = service.checkTransactions(accountNo);
		map.addAttribute("list", list);
		List<AccountActivities> getall = aservice.getall();
		map.addAttribute("lst", getall);
		return "checkTransactions";
	}
}
