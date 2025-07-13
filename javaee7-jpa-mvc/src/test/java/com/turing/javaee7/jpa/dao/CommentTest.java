package com.turing.javaee7.jpa.dao;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.turing.javaee7.jpa.model.entity.Comment;
import com.turing.javaee7.jpa.model.entity.Movie;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@Rollback(false)
public class CommentTest {
	@Autowired
	MovieRepository movieDao;
	
	@Test
	@Transactional
	public void testFetchMovies()
	{
		List<Movie> movies = this.movieDao.findAll();
		for(Movie movie: movies)
		{
			log.info("Movie "+movie);
			log.info("Comment size for "+movie.getId()+" size "+movie.getComments().size());
		}
	}
	//@Test
	@Transactional
	public void testInsertComment()
	{
		Optional<Movie> movieResult = this.movieDao.findById(1L);
		Movie movie = movieResult.get();
		
		Comment c1 = new Comment();
		c1.setComment("Comment 1 for Movie1");
		c1.setMovie(movie);
		movie.getComments().add(c1);
		
		Comment c2 = new Comment();
		c2.setMovie(movie);
		c2.setComment("Comment 2 for Movie1");
		movie.getComments().add(c2);
		
		this.movieDao.save(movie);
		
	}
	//@Test
	@Transactional
	public void testInsertMovieWithComment()
	{
	
		Optional<Movie> movieResult = this.movieDao.findById(2L);
		Movie movie = movieResult.get();

		Comment c1 = new Comment();
		c1.setComment("Comment 1 for Movie 2");
		c1.setMovie(movie);
		movie.getComments().add(c1);
		
		Comment c2 = new Comment();
		c2.setMovie(movie);
		c2.setComment("Comment 2 for Movie 2");
		movie.getComments().add(c2);
		
		this.movieDao.save(movie);
		
	}
	//@Test
	@Transactional
	public void testSelect()
	{
		Optional<Movie> movieResult = this.movieDao.findById(1L);
		Movie movie = movieResult.get();
		
		System.err.println("Comments "+movie.getComments());
		System.err.println("Another line ");
		
	
	}
	
	//@Test
	@Transactional
	public void testUpdateComment()
	{
	
		Optional<Movie> movieResult = this.movieDao.findById(5L);
		Movie movie = movieResult.get();;

		List<Comment> comments = movie.getComments();
		
		for(Comment comment : comments)
		{
			comment.setComment("Update " + comment.getComment());
		}
		this.movieDao.save(movie);
		
	}
	//@Test
	@Transactional
	public void testDeleteComment()
	{
	
		Optional<Movie> movieResult = this.movieDao.findById(5L);
		Movie movie = movieResult.get();;

		List<Comment> comments = movie.getComments();
		
		Comment commentToDelete = comments.get(0);
		comments.remove(0);
		
		//commentToDelete.setMovie(null);
		movie.setComments(comments);
		log.info("Comment size "+movie.getComments().size());
		this.movieDao.save(movie);
		
	}
	//@Test
	@Transactional
	public void testDeleteMovie()
	{
	
		Optional<Movie> movieResult = this.movieDao.findById(5L);
		Movie movie = movieResult.get();;

		
		this.movieDao.delete(movie);
		
	}
}
