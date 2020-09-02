package com.mybank.repository;

import java.math.BigDecimal;

import com.mybank.model.Account;

public interface AccountDAO {
	
	public Account getAccountDetails(Integer accountNumber) throws Exception;
	
	public BigDecimal getBalance(Integer accountNumber) throws Exception;
	
	public void updateBalance(Integer accountNumber, BigDecimal amount) throws Exception;

}
