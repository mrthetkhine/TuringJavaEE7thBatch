package com.turing.javaee7.mvc.demo.dto;

public record Product(String name,Double price) {

	public Product(String name, Double price) {
		this.name =name;
		this.price =price;
	}

}
