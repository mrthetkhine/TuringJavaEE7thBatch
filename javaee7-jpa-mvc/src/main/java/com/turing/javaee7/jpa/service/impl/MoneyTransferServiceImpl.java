package com.turing.javaee7.jpa.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.javaee7.jpa.dao.BankAccountDao;
import com.turing.javaee7.jpa.model.entity.BankAccount;
import com.turing.javaee7.jpa.service.MoneyTransferService;
import com.turing.javaee7.jpa.service.exception.FinancialException;

@Service
public class MoneyTransferServiceImpl implements MoneyTransferService{

	@Autowired
	BankAccountDao bankAccountDao;
	
	
	@Override
	public void sendMoney(Long fromAccount, Long toAccount, Integer amount)throws FinancialException,Exception {
		
		this.debit(fromAccount, amount);//-
		this.credit(toAccount, amount);//+
		
	}
	
	void debit(Long fromAccount,Integer amount) throws Exception,FinancialException
	{
		Optional<BankAccount> result = this.bankAccountDao.findById(fromAccount);
		if(result.isPresent())
		{
			BankAccount account = result.get();
			if(account.getBalance()>= amount)
			{
				account.setBalance( account.getBalance()-amount);
				this.bankAccountDao.save(account);
			}
			else
			{
				throw new FinancialException("Invalid debit amount");
			}
			
		}
		else
		{
			throw new Exception("Invalid account");
		}
	}
	void credit(Long fromAccount,Integer amount) throws Exception,FinancialException
	{
		Optional<BankAccount> result = this.bankAccountDao.findById(fromAccount);
		if(result.isPresent())
		{
			BankAccount account = result.get();
			
			if(amount >0)
			{
				account.setBalance( account.getBalance()+amount);
				this.bankAccountDao.save(account);
			}
			else
			{
				throw new FinancialException("Invalid credit amount");
			}
		}
		else
		{
			throw new Exception("Invalid account");
		}
	}

}
