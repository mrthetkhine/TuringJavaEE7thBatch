package com.turing.javaee7.mvc.demo.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class  BookDto {
	private String title;
	private String author;
	private String description;
	
}
