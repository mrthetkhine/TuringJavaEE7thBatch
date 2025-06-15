package com.turing.javaee7.mvc.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
	Long id;
	String title;
	String author;
	String description;
	Long price;
}
