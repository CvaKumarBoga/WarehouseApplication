package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.app.model.AccountActivities;
import com.app.model.DebitEntity;
import com.app.service.IAcActivitiesService;
@Component
public class DebitEntityValidaor implements Validator{

	@Autowired
	private IAcActivitiesService aaservice;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return DebitEntity.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		DebitEntity debitEntity = (DebitEntity) target;

		if(!(aaservice.isAccountNumberExist(debitEntity.getDebitAccountNo()))){
			errors.rejectValue("debitAccountNo", null,"Account number "+debitEntity.getDebitAccountNo()+" is invalid..");
			errors.rejectValue("fromAccount", null,"Account number "+debitEntity.getFromAccount()+" is invalid..");

		}

	}
}