package com.turing.javaee7.jpa.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.turing.javaee7.jpa.model.entity.Movie;
import com.turing.javaee7.jpa.model.entity.MovieDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@Rollback(false)
public class MovieDaoTest {
	@Autowired
	MovieDao movieDao;
	
	@Autowired
	MovieDetailsDao movieDetailsDao;
	
	@Test
	public void testInsertMovie()
	{
		for(int i=6;i< 20;i++)
		{
			Movie movie =new Movie();
			movie.setTitle("Movie "+i);
			movie.setGenre("Drama");
			movie.setYear(2005L);
			
			MovieDetails movieDetails = new MovieDetails();
			movieDetails.setDetails("Movie "+i+" details" );
			
			movie.setMovieDetails(movieDetails);
			movieDetails.setMovie(movie);
			
			this.movieDao.save(movie);
			
			//this.movieDetailsDao.save(movieDetails);
			
			assertNotNull(movie.getId());
			
			Optional<Movie> savedMovie = this.movieDao.findById(movie.getId());
			//assertEquals("Forrest Gump",savedMovie.get().getTitle());
			
			log.info("Movie "+movie);
		}
		
	}
	//@Test
	public void testSelect()
	{
		Optional<Movie> movieResult = this.movieDao.findById(1L);
		Movie movie = movieResult.get();
		
		System.err.println("Movie "+movie.getClass());
		System.err.println("Another line ");
		
		System.err.println("Movie Details "+movie.getMovieDetails());
	
	}
	//@Test
	public void testSelectAll()
	{
		List<Movie> movies = this.movieDao.findAll();
		for(Movie movie : movies)
		{
			log.info("Movie " +movie);
			log.info("Movie Details "+movie.getMovieDetails());
		}
	}
	//@Test
	public void testUpdate()
	{
		Optional<Movie> movieResult = this.movieDao.findById(3L);
		Movie movie = movieResult.get();
		movie.getMovieDetails().setDetails("Movie 3 Details Update");
		
		this.movieDao.save(movie);
	}
	//@Test
	public void testDelete()
	{
		Optional<Movie> movieResult = this.movieDao.findById(4L);
		Movie movie = movieResult.get();
		
		this.movieDao.delete(movie);
	}
}
