package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.UomType;
import com.app.service.IUomTypeService;

@Component
public class UomTypeValidator implements Validator {
	@Autowired
	private IUomTypeService service;

	@Override
	public boolean supports(Class<?> clz) {
		// TODO Auto-generated method stub
		return UomType.class.equals(clz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		UomType uom=(UomType)target;
		
		if(service.isUomModelExist(uom.getUomModel())) {
			errors.rejectValue("UomModel", null, uom.getUomModel()+"alredy exist");
		}
		
	}

	

}
