package com.turing.javaee7.jpa.repository;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.turing.javaee7.jpa.DelayUtil;
import com.turing.javaee7.jpa.model.Movie;
import com.turing.javaee7.jpa.model.MovieDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Rollback(false)
@SpringBootTest
public class MovieRepositoryTest {
	
	@Autowired
	ActorRepository actorRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Test
	public void testSaveMovie()
	{
		Movie movie = new Movie();
		movie.setName("Titanic");
		
		ArrayList<String> genres = new ArrayList<>();
		genres.add("Drama");
		movie.setGenres(genres);
		
		MovieDetails movieDetails = new MovieDetails();
		movieDetails.setDetails("Drama of sinking ship");
		movie.setDetails(movieDetails);
		
		movie.setDirector("James Cameron");
		
		List<String> ids = new ArrayList<>();
		ids.add("68a083e9a3ee5ecf75cc1a0b");
		ids.add("68a0845ef589a3b9b1ac36c2");
		
		
		
		this.actorRepository.findAllById(ids)
							.collectList()
							.flatMap(actors->{
								log.info("Actors "+actors);
								movie.setActors(actors);
								
								return this.movieRepository.save(movie);
							}).subscribe();
		DelayUtil.delay(2000);
	}
}
