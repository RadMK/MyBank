package com.mybank.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.model.Transaction;
import com.mybank.service.TransferService;

@RestController
public class AccountController {

	@Autowired
	private TransferService transferService;

	@PostMapping("/accounts/makeTransfer")
	public ResponseEntity<Object> makeTransfer(@RequestBody Transaction transaction) {
		BigDecimal updatedBalance = null;
		try {

			updatedBalance = transferService.makeTransfer(transaction.getFromAccountNumber(),
					transaction.getToAccountNumber(), transaction.getAmount());

		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok("Transfer success, updated Balance is : " + updatedBalance);
	}

}
