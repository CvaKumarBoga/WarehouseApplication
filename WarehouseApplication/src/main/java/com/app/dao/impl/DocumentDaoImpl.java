package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IDocumentDao;
import com.app.model.Document;

@Repository
public class DocumentDaoImpl implements IDocumentDao {
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveDocument(Document doc) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(doc);
	}
	public List<Object[]> getFileIdAndNames() {
		// TODO Auto-generated method stub
		String hql=" select fileId,fileName "
		           +" from com.app.model.Document ";
	
		@SuppressWarnings({"unchecked","deprecation"})
		List<Object[]> list=(List<Object[]>) ht.find(hql);
		return list;
	}
	

}
