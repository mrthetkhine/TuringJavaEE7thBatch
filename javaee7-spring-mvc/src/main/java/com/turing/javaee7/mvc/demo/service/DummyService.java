package com.turing.javaee7.mvc.demo.service;

import java.util.List;

import com.turing.javaee7.mvc.demo.dto.Product;

public interface DummyService {
	List<String> getItems();
	List<Product> getProducts();
}
