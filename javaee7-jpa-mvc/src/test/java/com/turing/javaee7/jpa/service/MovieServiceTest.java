package com.turing.javaee7.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.turing.javaee7.jpa.dao.BookDao;
import com.turing.javaee7.jpa.dao.BookDaoTest;
import com.turing.javaee7.jpa.dto.BookDto;
import com.turing.javaee7.jpa.model.entity.Book;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class MovieServiceTest {

	@MockitoBean
	BookDao bookDao;
	
	@Autowired
	BookService bookService;
	
	List<Book> books;
	@BeforeEach
    public void setup(){

       log.info("BeforeEach run before every test");
       this.books = new ArrayList<>();
       Book b1 = new Book();
       b1.setId(1L);
       b1.setAuthor("Author 1");
       b1.setTitle("Title 1");
       b1.setDescription("Description 1");
       b1.setPrice(100L);
       
       this.books.add(b1);
      
       Book b2 = new Book();
       b2.setId(2L);
       b2.setAuthor("Author 2");
       b2.setTitle("Title 2");
       b2.setDescription("Description 2");
       b2.setPrice(200L);
       
       this.books.add(b2);
       
    }

	@Test
	public void testGetAllBook()
	{
		MockitoAnnotations.openMocks(this);
		Mockito.when(this.bookDao.findAll()).thenReturn(this.books);
		List<Book> booksByDao = this.bookDao.findAll();
		log.info("Book return by mock "+booksByDao.size());
		
		List<BookDto> books = this.bookService.getAllBook();
		log.info("Size "+books.size());
	}

	
}
