package com.turing.javaee7.core.demo.common;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.turing.javaee7.core.demo.bean.InstantiationTracingBeanPostProcessor;
import com.turing.javaee7.core.demo.bean.PrototypeBeanExample;
import com.turing.javaee7.core.demo.service.impl.HelloWorldServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class Config {
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PrototypeBeanExample PrototypeBeanExample() {
		log.info("Bean created by configuration");
	    return new PrototypeBeanExample();
	}
	
	/*
	@Bean
	public BeanPostProcessor beanPostProcessor()
	{
		return new InstantiationTracingBeanPostProcessor();
	}
	*/
}
