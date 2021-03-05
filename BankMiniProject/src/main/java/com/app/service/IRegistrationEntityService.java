package com.app.service;

import java.util.List;

import com.app.model.RegistrationEntity;

public interface IRegistrationEntityService {

	public Integer saveRegistr(RegistrationEntity reg);
	public RegistrationEntity getOne(Integer id);
	public void updateRegistration(RegistrationEntity reg);
	public List<RegistrationEntity> getAllForms();
	public List<Object[]> getApplicants();
}
