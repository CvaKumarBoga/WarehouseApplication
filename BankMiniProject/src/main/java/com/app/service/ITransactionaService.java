package com.app.service;

import java.util.List;

import com.app.model.TransactionsEntity;

public interface ITransactionaService {

	public String saveTransaction(TransactionsEntity tr);
	public List<TransactionsEntity> getallTrans();
	public List<TransactionsEntity> checkTransactions(String accountNo);
}
