package com.turing.javaee7.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turing.javaee7.jpa.model.entity.BankAccount;


@Repository
public interface BankAccountDao extends JpaRepository<BankAccount, Long>{

}
