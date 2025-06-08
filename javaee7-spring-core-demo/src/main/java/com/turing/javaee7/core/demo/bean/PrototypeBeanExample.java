package com.turing.javaee7.core.demo.bean;

import org.springframework.stereotype.Component;

import com.turing.javaee7.core.demo.service.impl.HelloWorldServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Component
public class PrototypeBeanExample {
	public PrototypeBeanExample()
	{
		log.info("PrototypeBeanExample created ");
	}
}
