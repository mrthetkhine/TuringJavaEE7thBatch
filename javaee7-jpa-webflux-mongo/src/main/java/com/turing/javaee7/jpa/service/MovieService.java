package com.turing.javaee7.jpa.service;
import com.turing.javaee7.jpa.dto.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
public interface MovieService {
	Flux<MovieDto> getAllMovies();
	Mono<MovieDto> getMovieById(String movieId);
	Mono<MovieDto> saveMovie(MovieDto movieDto);
	Mono<MovieDto> updateMovie(MovieDto movieDto);
	Mono<MovieDto> deleteMovieById(String movieId);
	Mono<MovieDto> assignActorToMovie(String movieId,String actorId);
	
	Flux<MovieDto> getMovieWithAverageRatingGte(double rating);
	Flux<MovieDto> getMovieWithActorIn(String firstName);
	
}
