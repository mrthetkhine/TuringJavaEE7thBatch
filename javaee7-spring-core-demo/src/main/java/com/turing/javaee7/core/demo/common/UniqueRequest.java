package com.turing.javaee7.core.demo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequestScope
public class UniqueRequest {

	
	public UniqueRequest()
	{
		log.info("Unique request bean created ");
	}
	public void api()
	{
		log.info("Unique Rest API");
	}
}
