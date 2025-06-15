package com.turing.javaee7.mvc.demo.service;
import java.util.List;
import com.turing.javaee7.mvc.demo.dto.*;

public interface BookService {
	List<BookDto> getAllBooks();
	void saveBook(BookDto bookDto);
	BookDto getBookById(Long id);
	void updateBook(BookDto bookDto);
	void deleteBookById(Long id);
}
