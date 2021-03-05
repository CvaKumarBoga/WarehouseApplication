package com.app.dao;

import java.util.List;

import com.app.model.TransactionsEntity;

public interface ITransactionsDao {
	
	public String saveTransaction(TransactionsEntity tr);
	public List<TransactionsEntity> getallTrans();
	public List<TransactionsEntity> checkTransactions(String accountNo);
}
