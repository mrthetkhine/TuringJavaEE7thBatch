package com.turing.javaee7.mvc.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.javaee7.mvc.demo.commom.Mapper;
import com.turing.javaee7.mvc.demo.controller.api.exception.NotFoundException;
import com.turing.javaee7.mvc.demo.dto.BookDto;
import com.turing.javaee7.mvc.demo.model.Book;
import com.turing.javaee7.mvc.demo.repository.BookRepository;
import com.turing.javaee7.mvc.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	Mapper mapper;
	
	@Override
	public List<BookDto> getAllBooks() {
		// TODO Auto-generated method stub
		List<Book> books =  this.bookRepository.getAllBooks();
		
		/*
		List<BookDto> bookDtos = new ArrayList<>();
		for(Book book: books)
		{
			BookDto dto = new BookDto(book.getTitle(),book.getAuthor(),book.getDescription());
			bookDtos.add(dto);
		}
		return bookDtos;
		*/
		return this.mapper.mapList(books, BookDto.class);
	}

	@Override
	public void saveBook(BookDto bookDto) {
		Book book = this.mapper.map(bookDto, Book.class);
		this.bookRepository.saveBook(book);
	}

	@Override
	public BookDto getBookById(Long id)throws NotFoundException {
		Optional<Book> book = this.bookRepository.getBookById(id);
		if(book.isPresent())
		{
			return this.mapper.map(book.get(), BookDto.class);
		}
		else
		{
			throw new NotFoundException("Book with id "+id+" not found");
		}
		
	}

	@Override
	public void updateBook(BookDto bookDto)throws NotFoundException {
		Book book = this.mapper.map(bookDto, Book.class);
		Optional<Book> bookResult = this.bookRepository.getBookById(book.getId());
		if(bookResult.isPresent())
		{
			this.bookRepository.updateBook(book);
		}
		else
		{
			throw new NotFoundException("Book with id "+bookDto.getId()+" not found");
		}
		
		
	}

	@Override
	public void deleteBookById(Long id) throws NotFoundException {
		
		Optional<Book> book = this.bookRepository.getBookById(id);
		if(book.isPresent())
		{
			this.bookRepository.deleteBookById(id);
		}
		else
		{
			throw new NotFoundException("Book with id "+id+" not found");
		}
		
	}

}
