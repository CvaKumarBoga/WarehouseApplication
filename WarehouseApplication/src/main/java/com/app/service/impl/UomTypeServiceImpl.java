package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUomTypeDao;
import com.app.model.UomType;
import com.app.service.IUomTypeService;
@Service
public class UomTypeServiceImpl implements IUomTypeService {
	
	@Autowired
	private IUomTypeDao dao;
	
	@Override
	@Transactional
	public Integer saveUomType(UomType ut) {
		// TODO Auto-generated method stub
		return dao.saveUomType(ut);
	}

	@Override
	@Transactional
	public void updateUomType(UomType ut) {
		// TODO Auto-generated method stub
		dao.updateUomType(ut);
	}

	@Override
	@Transactional
	public void deleteUomType(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteUomType(id);
	}

	@Override
	@Transactional(readOnly=true)
	public UomType getOneUomType(Integer id) {
		// TODO Auto-generated method stub
		return dao.getOneUomType(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<UomType> getAllUomTypes() {
		// TODO Auto-generated method stub
		return dao.getAllUomTypes();
	}
	@Override
	public boolean isUomModelExist(String uomModel) {
		// TODO Auto-generated method stub
		return false;
	}
}
