package com.mybank.model;

import java.math.BigDecimal;


public class Transaction {
    private Integer fromAccountNumber;

    private Integer toAccountNumber;

    private BigDecimal amount;

	/**
	 * @return the fromAccountNumber
	 */
	public Integer getFromAccountNumber() {
		return fromAccountNumber;
	}

	/**
	 * @param fromAccountNumber the fromAccountNumber to set
	 */
	public void setFromAccountNumber(Integer fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	/**
	 * @return the toAccountNumber
	 */
	public Integer getToAccountNumber() {
		return toAccountNumber;
	}

	/**
	 * @param toAccountNumber the toAccountNumber to set
	 */
	public void setToAccountNumber(Integer toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
    
    

}