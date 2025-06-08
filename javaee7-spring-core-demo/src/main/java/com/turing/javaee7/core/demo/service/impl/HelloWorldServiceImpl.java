package com.turing.javaee7.core.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.turing.javaee7.core.demo.bean.PrototypeBeanExample;
import com.turing.javaee7.core.demo.service.HelloWorldService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Primary
public class HelloWorldServiceImpl implements HelloWorldService{

	@Autowired
	PrototypeBeanExample prototypeBean;
	
	public HelloWorldServiceImpl()
	{
		log.info("HelloWorldServiceImpl created");
	}
	@Override
	public String greet() {
		// TODO Auto-generated method stub
		return "Hello World";
	}

}
