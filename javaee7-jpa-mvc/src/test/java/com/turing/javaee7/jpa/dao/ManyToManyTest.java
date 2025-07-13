package com.turing.javaee7.jpa.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.turing.javaee7.jpa.model.entity.Actor;
import com.turing.javaee7.jpa.model.entity.Movie;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@Rollback(false)
public class ManyToManyTest {

	@Autowired
	MovieRepository movieDao;
	
	@Autowired
	ActorDao actorDao;
	
	//@Test
	@Transactional
	public void testSetActorToMovie()
	{
		Movie movie = this.movieDao.findById(3L).get();
		
		Actor leonardo = this.actorDao.findById(1L).get();
		Actor kateWinSlect = this.actorDao.findById(2L).get();
		
		movie.getActors().add(leonardo);
		//movie.getActors().add(kateWinSlect);
		
		//leonardo.getMovies().add(movie);
		//kateWinSlect.getMovies().add(movie);
		
		this.movieDao.save(movie);
	}
	@Test
	@Transactional
	public void testMovieAllSeect()
	{
		List<Movie> movies = this.movieDao.findAll();
		for(Movie movie : movies)
		{
			log.info("Movie "+movie.getId() + " have "+ movie.getActors().size());
		}
	}
}
