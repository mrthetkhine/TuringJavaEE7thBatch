package com.turing.javaee7.jpa.service;

import com.turing.javaee7.jpa.service.exception.FinancialException;

public interface MoneyTransferService {
	void sendMoney(Long fromAccount, Long toAccount, Integer amount) throws FinancialException,Exception;
}
