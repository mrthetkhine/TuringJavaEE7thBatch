package com.turing.javaee7.core.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HelloWorldController {
	
	public HelloWorldController()
	{
		log.info("Bean HelloWorldController created");
	}
	
	@GetMapping("/")
	String home()
	{
		log.info("controller / handled");
		return "home";
	}
	
}
