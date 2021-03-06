package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUomTypeDao;
import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;


@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {
	
	@Autowired
	private IWhUserTypeDao dao; 
	
	@Override
	@Transactional
	public Integer saveWhUserType(WhUserType wh) {
		// TODO Auto-generated method stub
		return dao.saveWhUserType(wh);
	}

	@Override
	@Transactional
	public void updateWhUserType(WhUserType wh) {
		// TODO Auto-generated method stub
		dao.updateWhUserType(wh);
	}

	@Override
	@Transactional
	public void deleteWhUserType(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteWhUserType(id);
	}

	@Override
	@Transactional(readOnly=true)
	public WhUserType getOneWhUserType(Integer id) {
		// TODO Auto-generated method stub
		return dao.getOneWhUserType(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<WhUserType> getAllWhUserTypes() {
		// TODO Auto-generated method stub
		return dao.getAllWhUserTypes();
	}

}
