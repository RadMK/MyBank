package com.mybank.repository;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mybank.entity.AccountEntity;
import com.mybank.exception.ResourceNotFoundException;
import com.mybank.model.Account;


@Repository
public class AccountDAOImpl implements AccountDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public BigDecimal getBalance(Integer accountNumber) throws Exception{

		String sql = "SELECT * FROM ACCOUNT WHERE accountnumber = ?";
		try {
			AccountEntity acct = jdbcTemplate.queryForObject(sql, new Object[] { accountNumber },
					new BeanPropertyRowMapper<>(AccountEntity.class));
			return acct.getBalance();
		} catch (Exception e) {
			throw new ResourceNotFoundException("Account not found for account number ::", "", accountNumber);
		}

	}

	public Account getAccountDetails(Integer accountNumber) throws Exception {
		String sql = "SELECT * FROM ACCOUNT WHERE accountnumber = ?";
		try {
			Account acct = jdbcTemplate.queryForObject(sql, new Object[] { accountNumber },
					new BeanPropertyRowMapper<>(Account.class));
			return acct;
		} catch (Exception e) {
			throw new ResourceNotFoundException("Account", "Balance", accountNumber);
		}
	}

	public void updateBalance(Integer accountNumber, BigDecimal amount) throws Exception{
		String sql = "update Account set balance = ? where accountnumber =?";
		try {
			jdbcTemplate.update(sql,amount,accountNumber);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Account", "Balance", accountNumber);
		}
	}
}
