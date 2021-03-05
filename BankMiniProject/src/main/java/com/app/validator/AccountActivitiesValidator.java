package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.app.model.AccountActivities;
import com.app.service.IAcActivitiesService;
@Component
public class AccountActivitiesValidator implements Validator{

	@Autowired
	private IAcActivitiesService service;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return AccountActivities.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		AccountActivities activities = (AccountActivities) target;

		if(service.isAccountNumberExist(activities.getAcNo())){
			errors.rejectValue("acNo", null,"Account number "+activities.getAcNo()+" is already exist!..");

		}

	}
}