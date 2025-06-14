package com.turing.javaee7.mvc.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.turing.javaee7.mvc.demo.service.DummyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/mvc")
public class MvcController {

	@Autowired
	DummyService dummyService;
	
	@GetMapping
	String mvc(Model model)
	{
		model.addAttribute("message", "Hello from mvc");
		log.info("MVC index controller");
		return "index";
	}
	@GetMapping("/admin")
	String admin(Model model)
	{
		model.addAttribute("admin", true);
		log.info("MVC admin controller");
		return "index";
	}
	@GetMapping("/list")
	String list(Model model)
	{
		
		model.addAttribute("items",this.dummyService.getItems());
		log.info("MVC list controller");
		return "list";
	}
	@GetMapping("/products")
	String productList(Model model)
	{
		
		model.addAttribute("products",this.dummyService.getProducts());
		log.info("MVC products controller");
		return "product";
	}
}
