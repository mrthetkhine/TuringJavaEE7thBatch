package com.turing.javaee7.jpa.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class HelloWorldController {
	
	@GetMapping(value="/hello")
	Mono<String> hello()
	{
		log.info("Thread Name " + Thread.currentThread().getName());
		
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Mono.just("Hello");
	}
}
