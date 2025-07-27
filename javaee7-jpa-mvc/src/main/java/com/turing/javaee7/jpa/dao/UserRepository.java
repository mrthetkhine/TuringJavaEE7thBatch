package com.turing.javaee7.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turing.javaee7.jpa.model.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{
	 User findByUsername(String username);
}
