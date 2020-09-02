package com.mybank.model;

import java.math.BigDecimal;

public class Account {

	private Integer accountNumber;
	private BigDecimal balance;
	/**
	 * @return the accNum
	 */
	public Integer getAccNum() {
		return accountNumber;
	}
	/**
	 * @param accNum the accNum to set
	 */
	public void setAccNum(Integer accNum) {
		this.accountNumber = accNum;
	}
	/**
	 * @return the balance
	 */
	public BigDecimal getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
