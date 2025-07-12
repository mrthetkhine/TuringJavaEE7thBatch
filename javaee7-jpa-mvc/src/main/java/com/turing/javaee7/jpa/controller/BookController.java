package com.turing.javaee7.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turing.javaee7.jpa.dto.BookDto;
import com.turing.javaee7.jpa.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping
	List<BookDto> getAllBook()
	{
		return this.bookService.getAllBook();
	}
	
}
