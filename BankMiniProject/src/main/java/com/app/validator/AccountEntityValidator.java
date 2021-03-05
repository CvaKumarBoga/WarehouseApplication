package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.AccountEntity;
import com.app.service.IAccountEntityService;

@Component
public class AccountEntityValidator implements Validator{
	
	@Autowired
	private IAccountEntityService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return AccountEntity.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//target is model class object
		AccountEntity ac=(AccountEntity) target;
		
		if(service.isAccountNumberExist(ac.getAccountNumber())) {
			errors.rejectValue("accountNumber", null, ac.getAccountNumber()+" is already exit");
		}
	}

}
