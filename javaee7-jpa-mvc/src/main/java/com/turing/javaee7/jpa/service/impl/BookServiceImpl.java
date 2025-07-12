package com.turing.javaee7.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.javaee7.jpa.common.Mapper;
import com.turing.javaee7.jpa.dao.BookDao;
import com.turing.javaee7.jpa.dto.BookDto;
import com.turing.javaee7.jpa.model.entity.Book;
import com.turing.javaee7.jpa.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	Mapper mapper;
	
	@Autowired
	BookDao bookDao;
	

	@Override
	public List<BookDto> getAllBook() {
		log.info("Book service getAllBook started");
		List<Book> books = this.bookDao.findAll();
		log.info("Book service getAllBook before returned");
		return this.mapper.mapList(books, BookDto.class);
		
	}

}
