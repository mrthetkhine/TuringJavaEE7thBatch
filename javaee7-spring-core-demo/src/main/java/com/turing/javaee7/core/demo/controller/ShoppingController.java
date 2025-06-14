package com.turing.javaee7.core.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turing.javaee7.core.demo.bean.ShoppingCart;


@RestController
@RequestMapping("/api/cart")
public class ShoppingController {

	@Autowired
	ShoppingCart cart;
	
	@GetMapping("/add")
	String addToCart(@RequestParam(name = "item") String  item)
	{
		this.cart.addToCart(item);
		return "Added";
	}
	@GetMapping("/items")
	String items()
	{
	
		return "Added "+this.cart.getNoOfItem();
	}
}
