package com.mybank.service.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybank.exception.ResourceNotFoundException;
import com.mybank.model.Account;
import com.mybank.repository.AccountDAO;
import com.mybank.service.AccountService;
import com.mybank.service.TransferService;

@Service
public class TransferServiceImpl implements TransferService {

	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountDAO accountDAO;

	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Override
	public BigDecimal makeTransfer(Integer fromAccountNumber, Integer toAccountNumber, BigDecimal amount) throws Exception {

		BigDecimal zero = new BigDecimal(0);
		// check if from account exits
		Account fromAcct = checkAccountDetails(fromAccountNumber);
		// check if to account exits
		Account toAcct = checkAccountDetails(toAccountNumber);
		// check if there are sufficient funds.
		BigDecimal fromBalance = fromAcct.getBalance();
		if (fromBalance.compareTo(zero)==1) {
			if (amount.compareTo(fromBalance) ==1) {
				// throw no sufficient funds
				throw new ResourceNotFoundException("Account doesnot have sufficient funds to transfer ::", "",
						fromAccountNumber);
			}

		} else {
			// throw no balance available
			throw new ResourceNotFoundException("Account doesnot have sufficient funds to transfer ::", "",
					fromAccountNumber);
		}

		// logic to make transfer
		fromAcct.setBalance(fromBalance.subtract(amount));
		toAcct.setBalance(toAcct.getBalance().add(amount));

		accountDAO.updateBalance(fromAccountNumber, fromAcct.getBalance());
		accountDAO.updateBalance(toAccountNumber, toAcct.getBalance());

		return fromAcct.getBalance();
	}

	private Account checkAccountDetails(Integer accountNumber) throws Exception {
		return accountService.getAccountDetails(accountNumber);
	}

}
