package com.turing.javaee7.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.javaee7.jpa.common.Mapper;
import com.turing.javaee7.jpa.dao.BookDao;
import com.turing.javaee7.jpa.dto.BookDto;
import com.turing.javaee7.jpa.model.entity.Book;
import com.turing.javaee7.jpa.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	Mapper mapper;
	
	@Autowired
	BookDao bookDao;
	

	@Override
	public List<BookDto> getAllBook() {
		List<Book> books = this.bookDao.findAll();
		return this.mapper.mapList(books, BookDto.class);
		
	}

}
