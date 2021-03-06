package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;
@Repository
public class UserDaoImpl implements IUserDao {
	@Autowired
	private HibernateTemplate ht;
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;

	public Integer saveUser(User user) {
		// TODO Auto-generated method stub
		user.setUserPwd(pwdEncoder.encode(user.getUserPwd()));
		return (Integer) ht.save(user);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		ht.update(user);
	}

	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		User u=new User();
		u.setId(id);
		ht.delete(u);
	}

	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(User.class, id);
	}
	
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return ht.loadAll(User.class);
	}
	
	
}
