package com.turing.javaee7.mvc.demo.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.turing.javaee7.mvc.demo.model.Book;
import com.turing.javaee7.mvc.demo.repository.BookRepository;

@Primary
@Repository
public class BookRepositoryJDBCImpl implements BookRepository{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Book> getAllBooks() {
	
		 return jdbcTemplate.query(
			      "SELECT id, title, author,description,price FROM Book;",
			      this::mapRowToBook);
	}
	private Book mapRowToBook(ResultSet row, int rowNum)throws SQLException
	{
		return new Book(row.getLong("ID"),
						row.getString("title"),
						row.getString("author") ,
						row.getString("description"),
						row.getLong("price"));
	}

	@Override
	public void saveBook(Book book) {
		this.jdbcTemplate.update("INSERT INTO book(title,author,description,price) "
									+"VALUES(?,?,?,?)",
				book.getTitle(),book.getAuthor(),book.getDescription(),book.getPrice());
		
	}

	@Override
	public Optional<Book> getBookById(Long id) {
		List<Book> books = jdbcTemplate.query(
			      "SELECT * FROM Book WHERE id=?",
			      this::mapRowToBook,id);
		if(books.size()>0)
		{
			return Optional.of(books.get(0));
		}
		else
		{
			return Optional.empty();
		}
		
		
	}

	@Override
	public void updateBook(Book book) {
		this.jdbcTemplate.update("UPDATE book "
				+"SET title=?, author =?, description=?,price=? WHERE ID=?",
				book.getTitle(),book.getAuthor(),
				book.getDescription(),book.getPrice(),book.getId());
		
	}

	@Override
	public void deleteBookById(Long id) {
		this.jdbcTemplate.update("DELETE FROM book WHERE ID=?",id);
		
	}

}
