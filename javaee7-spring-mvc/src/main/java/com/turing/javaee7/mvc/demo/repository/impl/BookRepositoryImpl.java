package com.turing.javaee7.mvc.demo.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.turing.javaee7.mvc.demo.model.Book;
import com.turing.javaee7.mvc.demo.repository.BookRepository;

@Repository
public class BookRepositoryImpl implements BookRepository{

	List<Book> books = new ArrayList<>();
	
	BookRepositoryImpl()
	{
		this.books.add(new Book("Title 1","Author 1","Description 1"));
		this.books.add(new Book("Title 2","Author 2","Description 2"));
	}
	@Override
	public List<Book> getAllBooks() {
		
		return this.books;
	}

}
