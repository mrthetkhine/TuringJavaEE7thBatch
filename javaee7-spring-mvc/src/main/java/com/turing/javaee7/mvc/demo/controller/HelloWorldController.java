package com.turing.javaee7.mvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HelloWorldController {

	@GetMapping("/")
	String index()
	{
		log.info("Index controller");
		return "index";
	}
}
