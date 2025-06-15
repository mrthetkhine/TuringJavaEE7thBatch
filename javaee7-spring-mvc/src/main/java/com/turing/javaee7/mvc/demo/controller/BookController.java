package com.turing.javaee7.mvc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.turing.javaee7.mvc.demo.commom.BookValidator;
import com.turing.javaee7.mvc.demo.dto.BookDto;
import com.turing.javaee7.mvc.demo.service.BookService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookService;
	
	//Custom validator setup
	@Autowired
	BookValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	
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
		//dto.setAuthor("Dummy Author");
		model.addAttribute("book",dto);
		
		log.info("Book new controller ");
		return "books/new";
	}
	/*
	@PostMapping("/new")
	String saveNewBook(@ModelAttribute("book") @Valid BookDto book,BindingResult result)
	{
		
		if(result.hasErrors())
		{
			log.info("Validation error");
		}
		else
		{
			log.info("Book save "+book);
		}
		return "books/new";
	}
	*/
	@PostMapping("/new")
	String saveNewBook(@ModelAttribute("book") @Validated BookDto book,BindingResult result,Model model)
	{
		
		if(result.hasErrors())
		{
			log.info("Validation error");
		}
		else
		{
			log.info("Book save "+book);
			this.bookService.saveBook(book);
			model.addAttribute("message", "Book successfully added");
			return "redirect:/books";
		}
		return "books/new";
	}
	@GetMapping("/edit/{id}")
	String editBook(@PathVariable("id") Long id,Model model)
	{
		BookDto dto = this.bookService.getBookById(id);
		//dto.setAuthor("Dummy Author");
		model.addAttribute("book",dto);
		model.addAttribute("edit", true);
		log.info("Edit book controller "+id);
		return "books/new";
	}
	@PostMapping("/edit")
	String updateBook(@ModelAttribute("book") @Validated BookDto book,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			log.info("Validation error");
		}
		else
		{
			log.info("Book save "+book);
			this.bookService.updateBook(book);
			model.addAttribute("message", "Book successfully updated");
			return "redirect:/books";
		}
		log.info("Update book controller "+book.getId());
		model.addAttribute("edit", true);
		return "books/new";
	}
	@GetMapping("/delete/{id}")
	String deleteBook(@PathVariable("id") Long id,Model model)
	{
		this.bookService.deleteBookById(id);
		//dto.setAuthor("Dummy Author");
		
		model.addAttribute("message", "Book successfully deleted");
		log.info("Delete book controller "+id);
		return "redirect:/books";
	}
}
