package com.turing.javaee7.jpa.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class MoneyTransferServiceTest {
	
	@Autowired
	MoneyTransferService transferService;
	
	
	@Test
	void transferTest()
	{
		try
		{
			this.transferService.sendMoney(1L, 2L, 1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
