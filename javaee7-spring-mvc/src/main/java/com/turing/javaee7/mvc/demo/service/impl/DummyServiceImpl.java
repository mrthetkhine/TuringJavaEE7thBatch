package com.turing.javaee7.mvc.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.turing.javaee7.mvc.demo.dto.Product;
import com.turing.javaee7.mvc.demo.service.DummyService;

@Service
public class DummyServiceImpl implements DummyService{

	@Override
	public List<String> getItems() {
		ArrayList<String> items = new ArrayList<>();
		
		items.add("Apple");
		items.add("Orange");
		items.add("Banana");
		
		return items;
		
	}

	@Override
	public List<Product> getProducts() {
		List<Product> products =new ArrayList<>();
		products.add(new Product("MacBook Pro",2000.0));
		products.add(new Product("IPhone 10",120.0));
		return products;
	}

}
