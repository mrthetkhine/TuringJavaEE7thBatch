package com.turing.javaee7.jpa.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class HelloWorldController {
	
	String blockingCode()
	{
		log.info("Thread Name " + Thread.currentThread().getName());
		try
		{
			Thread.sleep(10_000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Hello";
	}
	@GetMapping(value="/hello")
	Mono<String> hello()
	{
		
		
		return Mono.fromCallable(()->this.blockingCode())
					.publishOn(Schedulers.boundedElastic());
	}
}
