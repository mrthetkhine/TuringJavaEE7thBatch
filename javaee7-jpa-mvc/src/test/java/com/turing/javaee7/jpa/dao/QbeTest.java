package com.turing.javaee7.jpa.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.test.annotation.Rollback;

import com.turing.javaee7.jpa.model.entity.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@Rollback(false)
public class QbeTest {
	@Autowired
	MovieDao movieDao;
	
	//@Test
	void testMovieWithGenre()
	{
		Movie movie = new Movie();
		movie.setGenre("Drama");
		movie.setYear(2005L);
		ExampleMatcher matcher = ExampleMatcher.matching()
										.withIgnorePaths("genre");
		Example<Movie> example = Example.of(movie);
		
		List<Movie> movies = this.movieDao.findAll(example);
		
		movies.forEach(System.err::println);
	}
	//@Test
	void testMovieTitleStartWith()
	{
		Movie movie = new Movie();
		movie.setTitle("movie");
		
		ExampleMatcher matcher = ExampleMatcher.matching()
									.withStringMatcher(StringMatcher.STARTING); 
		Example<Movie> example = Example.of(movie,matcher);
		
		List<Movie> movies = this.movieDao.findAll(example);
		
		movies.forEach(System.err::println);
	}
	@Test
	void testMovieYearGt()
	{
		Movie movie = new Movie();
		movie.setYear(2009L);
		movie.setGenre("Drama");
		ExampleMatcher matcher = ExampleMatcher.matching()
									.withIgnorePaths("genre");
		Example<Movie> example = Example.of(movie,matcher);
		
		List<Movie> movies = this.movieDao.findAll(example);
		
		movies.forEach(System.err::println);
	}
}
