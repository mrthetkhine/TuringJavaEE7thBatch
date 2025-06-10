package com.turing.javaee7.core.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.turing.javaee7.core.demo.bean.PrototypeBeanExample;
import com.turing.javaee7.core.demo.common.UniqueRequest;
import com.turing.javaee7.core.demo.service.HelloWorldService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HelloWorldController {
	
	@Value("${catalog.name}") 
	String catalog;
	
	@Autowired
	PrototypeBeanExample prototypeBean;
	
	@Autowired
	UniqueRequest uniqueRequest;
	
	int count = 0;
	//@Autowired
	private final HelloWorldService helloWorldService;
	
	//Constructor injection
	public HelloWorldController(HelloWorldService helloWorldService)
	{
		log.info("Bean HelloWorldController created");
		this.helloWorldService = helloWorldService;
		
	}
	
	@GetMapping("/")
	String home()
	{
		this.count++;
		log.info("controller / handled "+this.helloWorldService.greet());
		log.info("Count "+this.count);
		this.uniqueRequest.api();
		log.info("Catalog "+this.catalog);
		return "home";
	}
	@GetMapping("/hello")
	public String handle(Model model) {
		model.addAttribute("message", "Hello World!");
		return "index";
	}
	
}
