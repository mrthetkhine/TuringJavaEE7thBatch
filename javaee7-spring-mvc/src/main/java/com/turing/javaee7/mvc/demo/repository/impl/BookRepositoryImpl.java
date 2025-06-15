package com.turing.javaee7.mvc.demo.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.turing.javaee7.mvc.demo.model.Book;
import com.turing.javaee7.mvc.demo.repository.BookRepository;

@Repository
public class BookRepositoryImpl implements BookRepository{

	List<Book> books = new ArrayList<>();
	
	Long nextId = 3L;
	BookRepositoryImpl()
	{
		this.books.add(new Book(1L,"Title 1","Author 1","Description 1",10L));
		this.books.add(new Book(2L,"Title 2","Author 2","Description 2",20L));
	}
	@Override
	public List<Book> getAllBooks() {
		
		return this.books;
	}
	@Override
	public void saveBook(Book book) {
		book.setId(nextId++);
		this.books.add(book);
		
	}
	@Override
	public Book getBookById(Long id) {
		Book book = null;
		for(Book b : this.books)
		{
			if(b.getId().longValue() == id)
			{
				return b;
			}
		}
		return book;
	}
	@Override
	public void updateBook(Book book) {
		for(Book b : this.books)
		{
			if(b.getId().longValue() == book.getId().longValue())
			{
				b.setAuthor(book.getAuthor());
				b.setTitle(book.getTitle());
				b.setDescription(book.getDescription());
				b.setPrice(book.getPrice());
				break;
			}
		}
		
	}
	@Override
	public void deleteBookById(Long id) {
		Book book = this.getBookById(id);
		this.books.remove(book);
		
	}

}
