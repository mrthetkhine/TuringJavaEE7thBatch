package com.turing.javaee7.jpa.dao.querymethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.turing.javaee7.jpa.dao.MovieDao;
import com.turing.javaee7.jpa.dao.MovieDetailsDao;
import com.turing.javaee7.jpa.dao.MovieRepository;
import com.turing.javaee7.jpa.model.entity.Movie;
import com.turing.javaee7.jpa.model.entity.MovieDetails;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@Rollback(false)
public class MovieQueryMethodTest {
	@Autowired
	MovieRepository movieDao;
	
	
	
	//@Test
	public void testFindByYear()
	{
		List<Movie> movies = this.movieDao.findByYearGreaterThan(2009L);
		movies.forEach(System.err::println);
	}
	//@Test
	public void testFindByYearAndGenre()
	{
		List<Movie> movies = this.movieDao.findByYearAndGenre(2009L,"Sci-Fi");
		movies.forEach(System.err::println);
	}
	//@Test
	public void testFindByGenresIn()
	{
		List<String> genres = new ArrayList<>();
		genres.add("Sci-Fi");
		genres.add("Drama");
		List<Movie> movies = this.movieDao.findByGenreIn(genres);
		movies.forEach(System.err::println);
	}
	//@Test
	public void testFindByYearOrGenre()
	{
		List<Movie> movies = this.movieDao.findByYearOrGenre(2009L,"Sci-Fi");
		movies.forEach(System.err::println);
	}
	//@Test
	public void testFindByGenreOrderByYear()
	{
		List<Movie> movies = this.movieDao.findByGenreOrderByYearDesc("Sci-Fi");
		movies.forEach(System.err::println);
	}
	//@Test
	public void testFindByTitleIgnoreCase()
	{
		List<Movie> movies = this.movieDao.findByTitleIgnoreCase("titanic");
		movies.forEach(System.err::println);
	}
	//@Test
	public void testFindMovieByDistinctGenre()
	{
		List<Movie> movies = this.movieDao.findDistinctMovieByGenre("Drama");
		movies.forEach(System.err::println);
	}
	//@Test
	public void testCountByGenre()
	{
		long count = this.movieDao.countByGenre("Sci-Fi");
		log.info("Count "+count);
		
		long total = this.movieDao.count();
		log.info("Total movie "+total);
	}
	//@Test
	public void testExistMovieByGenre()
	{
		boolean exist = this.movieDao.existsMovieByGenre("Horror");
		log.info("Exist "+exist);
		
	}
	//@Test
	public void testMovieTitleContains()
	{
		List<Movie> movies = this.movieDao.findByTitleContains("movie");
		movies.forEach(System.err::println);
		
	}
	//@Test
	public void testMovieTitleLike()
	{
		List<Movie> movies = this.movieDao.findByTitleLike("movie%");
		movies.forEach(System.err::println);
		
	}
	//@Test
	public void testMovieFindFirst()
	{
		List<Movie> movies = this.movieDao.findFirst2ByGenre("Drama");
		movies.forEach(System.err::println);
		
	}
	//@Test
	@Transactional
	public void testMovieDeleteBy()
	{
		long count = this.movieDao.deleteByGenre("Horror");
		log.info("Deleted count "+count);
		
	}
	//@Test
	public void testMovieByYearJPAQuery()
	{
		List<Movie> movies = this.movieDao.findMovieByYear(2005L);
		movies.forEach(System.err::println);
		
	}
	@Test
	public void testMovieByYearJPAQueryNative()
	{
		List<Movie> movies = this.movieDao.findMovieByYearNative(2005L);
		movies.forEach(System.err::println);
		
	}
}
