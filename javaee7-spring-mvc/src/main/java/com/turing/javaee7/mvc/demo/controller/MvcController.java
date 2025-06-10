package com.turing.javaee7.mvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MvcController {

	@GetMapping("/mvc")
	String mvc(Model model)
	{
		model.addAttribute("message", "Hello from mvc");
		log.info("MVC index controller");
		return "index";
	}
}
