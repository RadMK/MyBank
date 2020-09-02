package com.mybank.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybank.model.Account;
import com.mybank.repository.AccountDAO;
import com.mybank.service.AccountService;

/**
 * Created by Radha_Botla
 */
@Service
public class AccountServiceImpl implements AccountService {


	@Autowired
	private AccountDAO accountDAO;

	@Override
	public BigDecimal getBalance(Integer accountNumber) throws Exception{
		return accountDAO.getBalance(accountNumber);
	}

	@Override
	public Account getAccountDetails(Integer accountNumber) throws Exception {
		return accountDAO.getAccountDetails(accountNumber);
	}

}