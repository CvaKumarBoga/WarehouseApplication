package com.app.dao;

import java.util.List;

import com.app.model.RegistrationEntity;

public interface IRegistrationEntityDao {

	public Integer saveRegistr(RegistrationEntity reg);
	public RegistrationEntity getOne(Integer id);
	public void updateRegistration(RegistrationEntity reg);
	public List<RegistrationEntity> getAllForms();
	public List<Object[]> getApplicants(); 
}
