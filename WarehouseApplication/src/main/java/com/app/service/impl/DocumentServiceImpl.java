package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IDocumentDao;
import com.app.model.Document;
import com.app.service.IDocumentService;

@Service
public class DocumentServiceImpl implements IDocumentService {
	
	@Autowired
	private IDocumentDao dao;

	@Override
	@Transactional
	public Integer saveDocument(Document doc) {
		// TODO Auto-generated method stub
		return dao.saveDocument(doc);
	}
	@Override
	public List<Object[]> getFileIdAndNames() {
		// TODO Auto-generated method stub
		return dao.getFileIdAndNames();
	}

}
