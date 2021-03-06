package com.app.dao;

import java.util.List;

import com.app.model.UomType;

public interface IUomTypeDao {
	public Integer saveUomType(UomType ut);
	public void updateUomType(UomType ut);
	public void deleteUomType(Integer id);
	public UomType getOneUomType(Integer id);
	public List<UomType> getAllUomTypes();
	public boolean isUomModelExist(String uomModel);
}
