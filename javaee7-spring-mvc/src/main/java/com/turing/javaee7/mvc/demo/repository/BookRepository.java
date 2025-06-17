package com.turing.javaee7.mvc.demo.repository;
import java.util.List;
import java.util.Optional;

import com.turing.javaee7.mvc.demo.model.*;

public interface BookRepository {
	List<Book> getAllBooks();
	void saveBook(Book book);
	Optional<Book> getBookById(Long id);
	void updateBook(Book book);
	void deleteBookById(Long id);
}
