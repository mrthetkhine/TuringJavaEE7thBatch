package com.turing.javaee7.mvc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.turing.javaee7.mvc.demo.dto.BookDto;
import com.turing.javaee7.mvc.demo.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping
	String index(Model model)
	{
		List<BookDto> books = this.bookService.getAllBooks();
		model.addAttribute("books",books);
		/*
		for(BookDto dto : books)
		{
			log.info("Title "+dto.getTitle());
		}
		*/
		return "books/index";
	}
	@GetMapping("/new")
	String newBook(Model model)
	{
		BookDto dto =new BookDto();
		model.addAttribute("book",dto);
		
		return "books/new";
	}
	@PostMapping("/new")
	String saveNewBook(@ModelAttribute("book") BookDto book)
	{
		log.info("Book save "+book);
		
		return "books/new";
	}
}
