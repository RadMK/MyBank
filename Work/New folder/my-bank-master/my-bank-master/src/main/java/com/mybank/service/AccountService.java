package com.mybank.service;

import java.math.BigDecimal;

import com.mybank.model.Account;

public interface AccountService {

	public BigDecimal getBalance(Integer accountNumber) throws Exception;

	public Account getAccountDetails(Integer accountNumber) throws Exception;
}
