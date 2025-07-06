package com.turing.javaee7.jpa.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.turing.javaee7.jpa.dto.MovieIdCommentCount;
import com.turing.javaee7.jpa.dto.TitleAndGenre;
import com.turing.javaee7.jpa.dto.TitleAndGenreC;
import com.turing.javaee7.jpa.dto.TitleGenre;
import com.turing.javaee7.jpa.model.entity.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@Rollback(false)
public class MovieJpqlTest {

	@Autowired
	MovieDao movieDao;
	
	@Autowired
	CommentDao commentDao;
	
	//@Test
	public void testGetAll()
	{
		List<Movie> movies = this.movieDao.getAllMovie();
		movies.forEach(System.out::println);
	}
	//@Test
	public void testGetAllWithGenre()
	{
		List<Movie> movies = this.movieDao.findAllMovieWithGenre("Drama");
		movies.forEach(System.out::println);
	}
	//@Test
	public void testGetAllWithGenreWithCount()
	{
		long count = this.movieDao.findMovieCountWithGenre("Drama");
		System.out.println("Drama count "+count);
		
	}
	//@Test
	public void testFindMovieWithTitleAndGenre()
	{
		List<TitleAndGenre> movies = this.movieDao.findAllMovieWithTitleAndGenre();
		for(TitleAndGenre data : movies)
		{
			log.info("Title " + data.getTitle() +" genre "+data.getGenre());
		}
		
	}
	//@Test
	public void testFindMovieWithTitleAndGenreWithClassBasedProje()
	{
		List<TitleGenre> movies = this.movieDao.findAllMovieWithTitleAndGenreWithClassProjection();
		for(TitleGenre data : movies)
		{
			log.info("Title " + data.title()+" genre "+data.genre());
		}
		
	}
	//@Test
	public void testJPQLFindMovieGtYear()
	{
		List<Movie> movies  = this.movieDao.findMovieWithYearGt(2005L);
		movies.forEach(System.out::println);
		
	}
	//@Test
	public void testFindMovieWithTitleAndGenreWithClass()
	{
		List<TitleAndGenreC> movies = this.movieDao.findAllMovieWithTitleAndGenreC();
		for(TitleAndGenreC data : movies)
		{
			log.info("Title " + data.getTitle()+" genre "+data.getGenere());
		}
		
	}
	
	//@Test
	public void testFindAllMovieWithActorIn()
	{
		List<Movie> movies = this.movieDao.findAllMovieWithActorIn("Leonardo DiCaprio");
		movies.forEach(System.out::println);
	}
	//@Test
	public void testLeftJoin()
	{
		List<Movie> movies = this.movieDao.findAllMovieWithActorInLeftJoinWithActorIn(1L);
		movies.forEach(System.out::println);
	}
	//@Test
	public void testJpqlOrderBY()
	{
		List<Movie> movies = this.movieDao.findAllMovieOrderByYear();
		movies.forEach(System.out::println);
	}
	@Test
	public void testJpqlGroupBY()
	{
		List<MovieIdCommentCount> items = this.commentDao.getNoOfCommentByMovieId();
		for(MovieIdCommentCount data : items)
		{
			log.info("Movie Id "+ data.movieId() + " Comment "+data.commentCount());
		}
	}
}
