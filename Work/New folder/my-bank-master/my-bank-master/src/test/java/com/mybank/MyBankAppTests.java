package com.mybank;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.mybank.model.Transaction;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyBankAppTests {

	@Autowired
	private TestRestTemplate restTemplate;
	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testAccount() {
		Transaction transaction = new Transaction();
		transaction.setFromAccountNumber(2347);
		transaction.setToAccountNumber(1236);
		transaction.setAmount(new BigDecimal(10));
		ResponseEntity<String> postResponse = restTemplate.postForEntity(getRootUrl() + "/accounts/makeTransfer", transaction, String.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
	}

}
