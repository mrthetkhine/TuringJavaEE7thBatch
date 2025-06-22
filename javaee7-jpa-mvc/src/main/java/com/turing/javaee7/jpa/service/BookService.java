package com.turing.javaee7.jpa.service;

import java.util.List;

import com.turing.javaee7.jpa.dto.BookDto;

public interface BookService {
	List<BookDto> getAllBook();
}
