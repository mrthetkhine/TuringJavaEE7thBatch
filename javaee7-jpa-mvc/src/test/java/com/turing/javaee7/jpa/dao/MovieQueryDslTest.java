package com.turing.javaee7.jpa.dao;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.querydsl.core.Tuple;
import com.turing.javaee7.jpa.dao.MovieDao;
import com.turing.javaee7.jpa.dto.CountAndGenere;
import com.turing.javaee7.jpa.dto.MovieIdCommentCount;
import com.turing.javaee7.jpa.dto.TitleAndGenre;
import com.turing.javaee7.jpa.dto.TitleAndGenreC;
import com.turing.javaee7.jpa.dto.TitleGenre;
import com.turing.javaee7.jpa.model.entity.Movie;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootTest
@Rollback(false)
public class MovieQueryDslTest {

	@Autowired
	MovieDao movieDao;
	
	//@Test
	public void testMovieByYear()
	{
		List<Movie> movies = this.movieDao.finByYear(2009L);
		movies.forEach(System.out::println);
	}
	//@Test
	public void testMovieByGenre()
	{
		Movie movie = this.movieDao.getFirstMovieByGenre("Drama");
		log.info("Movie "+movie);
	}
	//@Test
	public void testMovieByYearAndGenre()
	{
		List<Movie> movies = this.movieDao.finByYearAndGenre(null,null);
		movies.forEach(System.out::println);
	}
	//@Test
	public void testMovieWhereActorIn()
	{
		List<Movie> movies = this.movieDao.findMovieWithActor("Leonardo");
		movies.forEach(System.out::println);
	}
	//@Test
	public void testMovieOrderByYear()
	{
		List<Movie> movies = this.movieDao.findMovieOrderByYear();
		movies.forEach(System.out::println);
	}
	//@Test
	public void testMovieGroupByGenre()
	{
		List<CountAndGenere> movies = this.movieDao.findMovieGroupByGenre();
		movies.forEach(System.out::println);
	}
	//@Test
	public void testMovieProjection()
	{
		List<Tuple> movies = this.movieDao.getAllMovieWithIdName();
		for(Tuple tuple : movies)
		{
			log.info("ID "+tuple.get(0, Long.class)+" Name "+tuple.get(1,String.class));
		}
	}
	//@Test
	public void testMovieWithGenreSubquery()
	{
		List<Movie> movies = this.movieDao.findMovieWithGenreSubquery("Drama");
		movies.forEach(System.out::println);
	}
	@Test
	public void testMovieWithTitles()
	{
		List<String> titles= new ArrayList<>();
		titles.add("Titanic");
		titles.add("Forrest Gump");
		
		List<Movie> movies = this.movieDao.findMoviesWithTitle(titles);
		movies.forEach(System.out::println);
	}
}
