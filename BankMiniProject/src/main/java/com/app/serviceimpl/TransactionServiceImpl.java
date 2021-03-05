package com.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ITransactionsDao;
import com.app.model.TransactionsEntity;
import com.app.service.ITransactionaService;
@Service
public class TransactionServiceImpl implements ITransactionaService{

	@Autowired
	private ITransactionsDao dao;

	@Override
	@Transactional
	public String saveTransaction(TransactionsEntity tr) {
		// TODO Auto-generated method stub
		return dao.saveTransaction(tr);
	}
	@Transactional(readOnly = true)
	@Override
	public List<TransactionsEntity> getallTrans() {
		// TODO Auto-generated method stub
		return dao.getallTrans();
	}
	@Transactional(readOnly = true)
	@Override
	public List<TransactionsEntity> checkTransactions(String accountNo) {
		// TODO Auto-generated method stub
		return dao.checkTransactions(accountNo);
	}
}
