package com.turing.javaee7.jpa.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.turing.javaee7.jpa.model.entity.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class MovieDaoTest {
	@Autowired
	MovieDao movieDao;
	
	@Test
	public void testInsertMovie()
	{
		Movie movie =new Movie();
		movie.setTitle("Forrest Gump");
		movie.setGenre("Drama");
		movie.setYear(2009L);
		
		this.movieDao.save(movie);
		
		assertNotNull(movie.getId());
		
		Optional<Movie> savedMovie = this.movieDao.findById(movie.getId());
		assertEquals("Forrest Gump",savedMovie.get().getTitle());
		
		log.info("Movie "+movie);
	}
}
