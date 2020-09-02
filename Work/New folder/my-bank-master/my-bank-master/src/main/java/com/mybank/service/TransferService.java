package com.mybank.service;

import java.math.BigDecimal;

public interface TransferService {
	
	BigDecimal makeTransfer(Integer fromAccountNumber, Integer toAccountNumber, BigDecimal amount) throws Exception; 

}
