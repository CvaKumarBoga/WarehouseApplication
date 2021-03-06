package com.app.service;

import java.util.List;

import com.app.model.UomType;

public interface IUomTypeService {
	public Integer saveUomType(UomType ut);
	public void updateUomType(UomType ut);
	public void deleteUomType(Integer id);
	public UomType getOneUomType(Integer id);
	public List<UomType> getAllUomTypes();
	public boolean isUomModelExist(String uomModel);
}
