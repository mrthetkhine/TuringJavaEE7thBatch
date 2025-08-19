package com.turing.javaee7.jpa.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.turing.javaee7.jpa.DelayUtil;
import com.turing.javaee7.jpa.repository.MovieRepositoryTest;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Rollback(false)
@SpringBootTest
public class MovieServiceTest {
	@Autowired
	MovieService movieService;
	
	@Test
	public void testGetMovieWithAverageRating()
	{
		this.movieService.getMovieWithAverageRatingGte(3.0)
						.subscribe();
						
		DelayUtil.delay(2000);
	}
}
