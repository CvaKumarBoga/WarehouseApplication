package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.model.User;
import com.app.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao dao;
	
	@Override
	@Transactional
	public Integer saveUser(User user) {
		// TODO Auto-generated method stub
		return dao.saveUser(user);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		dao.updateUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteUser(id);
	}

	@Override
	@Transactional(readOnly=true)
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return dao.getUserById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return dao.getAllUsers();
	}

}
