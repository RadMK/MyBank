package com.mybank.service;

import java.math.BigDecimal;

import com.mybank.model.Transaction;

public interface TransferService {
	
	BigDecimal makeTransfer(Transaction transaction) throws Exception; 

}
