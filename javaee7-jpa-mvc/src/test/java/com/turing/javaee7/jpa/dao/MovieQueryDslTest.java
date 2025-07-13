package com.turing.javaee7.jpa.dao;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.turing.javaee7.jpa.dao.MovieDao;
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
	
	@Test
	public void testMovieByYear()
	{
		List<Movie> movies = this.movieDao.finByYear(2009L);
		movies.forEach(System.out::println);
	}
	
}
