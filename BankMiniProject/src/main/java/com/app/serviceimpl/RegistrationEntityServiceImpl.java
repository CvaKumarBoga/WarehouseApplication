package com.app.serviceimpl;

import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IRegistrationEntityDao;
import com.app.model.RegistrationEntity;
import com.app.service.IRegistrationEntityService;
@Service
public class RegistrationEntityServiceImpl implements IRegistrationEntityService {

	@Autowired
	private IRegistrationEntityDao dao;

	@Transactional
	@Override
	public Integer saveRegistr(RegistrationEntity reg) {
		// TODO Auto-generated method stub
		return dao.saveRegistr(reg);
	}
	
	@Transactional(readOnly = true)
	@Override
	public RegistrationEntity getOne(Integer id) {
		// TODO Auto-generated method stub
		return dao.getOne(id);
	}
	
	@Transactional
	@Override
	public void updateRegistration(RegistrationEntity reg) {
		// TODO Auto-generated method stub
		dao.updateRegistration(reg);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<RegistrationEntity> getAllForms() {
		// TODO Auto-generated method stub
		return dao.getAllForms();
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Object[]> getApplicants() {
		// TODO Auto-generated method stub
		return dao.getApplicants();
	}
}
