package com.app.dao;

import java.util.List;

import com.app.model.WhUserType;

public interface IWhUserTypeDao {
	public Integer saveWhUserType(WhUserType wh);
	public void updateWhUserType(WhUserType wh);
	public void deleteWhUserType(Integer id);
	public WhUserType getOneWhUserType(Integer id);
	public List<WhUserType> getAllWhUserTypes();

}
