package com.turing.javaee7.jpa.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.turing.javaee7.jpa.model.entity.Book;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BookDaoTest {
	@Autowired
	BookDao bookDao;
	
	@Test
	public void testSaveBook()
	{
		Book book = new Book();
		//book.setId(2L);
		book.setTitle("Title 3");
		book.setAuthor("Author 3");
		
		book.setDescription("Description 3");
		book.setPrice(300L);
		
		this.bookDao.save(book);
	}
	@Test
	public void testGetAllBook()
	{
		//Arrange,Act
		List<Book> books = this.bookDao.findAll();
		
		//Assert
		assertTrue(books.size()>0);
		for(Book b : books)
		{
			log.info("Book "+b);
		}
		
	}
	//@Transactional
	@Test
	public void testGetById()
	{
		Optional<Book> book = this.bookDao.findById(1L);
		assertEquals("Victor Frankl",book.get().getAuthor());
	}
	//@Test
	public void testDeleteById()
	{
		List<Book> books = this.bookDao.findAll();
		int previousSize = books.size();
		this.bookDao.deleteById(3L);
		
		books = this.bookDao.findAll();
		int currentSize= books.size();
		assertTrue(previousSize> currentSize);
	}
}
