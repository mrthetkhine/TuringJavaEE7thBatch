package com.turing.javaee7.mvc.demo.service;
import java.util.List;

import com.turing.javaee7.mvc.demo.controller.api.exception.NotFoundException;
import com.turing.javaee7.mvc.demo.dto.*;

public interface BookService {
	List<BookDto> getAllBooks();
	void saveBook(BookDto bookDto);
	BookDto getBookById(Long id)throws NotFoundException;
	void updateBook(BookDto bookDto) throws NotFoundException;
	void deleteBookById(Long id)throws NotFoundException;;
}
