package com.turing.javaee7.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;

import com.turing.javaee7.jpa.dao.specification.MovieSpecification;
import com.turing.javaee7.jpa.model.entity.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@Rollback(false)
public class MovieSpecificationTest {

	@Autowired
	MovieDao movieDao;
	
	//@Test
	public void testMovieInYear()
	{
		List<Movie> movies = this.movieDao.findAll(MovieSpecification.getAllMovieInYear(2009));
		movies.forEach(System.out::println);
	}
	//@Test
	public void testMovieTitleOrYear()
	{
		Specification<Movie> spec = MovieSpecification.getMovieByTitleOrYear(null, null);
				
		List<Movie> movies = this.movieDao.findAll(spec);
		movies.forEach(System.out::println);
	}
	//@Test
	public void testMovieInYearGt()
	{
		List<Movie> movies = this.movieDao.findAll(MovieSpecification.getMovieByYearGt(2009L));
		movies.forEach(System.out::println);
	}
	//@Test
	public void testMovieByTitleOrYear()
	{
		Specification<Movie> spec1 = MovieSpecification.getAllMovieByTitle("Titanic");
		Specification<Movie> spec2 = MovieSpecification.getAllMovieInYear(2009);
		Specification<Movie> spec = spec1.or(spec2);
		List<Movie> movies = this.movieDao.findAll(spec);
		movies.forEach(System.out::println);
	}
	//@Test
	public void testMovieWhereActorIn()
	{
		Specification<Movie> spec = MovieSpecification.getMovieWhereActorIn("leonardo");
		List<Movie> movies = this.movieDao.findAll(spec);
		movies.forEach(System.out::println);
	}
	//@Test
	public void testMovieOrderBy()
	{
		Specification<Movie> spec = MovieSpecification.getMovieOrderByYear();
		List<Movie> movies = this.movieDao.findAll(spec);
		movies.forEach(System.out::println);
	}
	@Test
	public void testMovieWhereGenreIn()
	{
		List<String> genres = new ArrayList<>();
		genres.add("Drama");
		genres.add("Sci-Fi");
		Specification<Movie> spec = MovieSpecification.getMovieInGenere(genres);
		List<Movie> movies = this.movieDao.findAll(spec);
		movies.forEach(System.out::println);
	}
}
