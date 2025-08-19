package com.turing.javaee7.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.javaee7.jpa.common.Mapper;
import com.turing.javaee7.jpa.dto.MovieDto;
import com.turing.javaee7.jpa.model.Movie;
import com.turing.javaee7.jpa.repository.ActorRepository;
import com.turing.javaee7.jpa.repository.MovieRepository;
import com.turing.javaee7.jpa.repository.ReviewRepository;
import com.turing.javaee7.jpa.service.MovieService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	Mapper mapper;
	
	@Autowired
	ActorRepository actorRepository;
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@Override
	public Flux<MovieDto> getAllMovies() {
		
		return this.movieRepository.findAll()
									.map(movie->this.mapper.map(movie, MovieDto.class));
	}
	@Override
	public Mono<MovieDto> getMovieById(String movieId)
	{
		return this.movieRepository
					.findById(movieId)
					.switchIfEmpty(Mono.error(new RuntimeException("Movie with id "+movieId+" not found")))
					.map(model->this.mapper.map(model,MovieDto.class));
	}
	@Override
	public Mono<MovieDto> saveMovie(MovieDto movieDto) {
		
		Movie movie = this.mapper.map(movieDto, Movie.class);
		return this.movieRepository.save(movie)
									.map(model->this.mapper.map(model, MovieDto.class));
	}
	@Override
	public Mono<MovieDto> updateMovie(MovieDto movieDto) {
		
		return this.movieRepository.findById(movieDto.getId())
					.switchIfEmpty(Mono.error(new RuntimeException("Movie with id "+movieDto.getId()+" not found")))
					.flatMap(movie->{
						movie.setName(movieDto.getName());
						movie.setCreatedAt(movieDto.getCreatedAt());
						movie.setGenres(movieDto.getGenres());
						movie.setDirector(movieDto.getDirector());
						
						movie.getDetails().setDetails(movieDto.getDetails().getDetails());
						
						return this.movieRepository.save(movie);
					})
					.map(model->this.mapper.map(model, MovieDto.class));
	}
	@Override
	public Mono<MovieDto> deleteMovieById(String movieId) {
		return this.movieRepository
				.findById(movieId)
				.switchIfEmpty(Mono.error(new RuntimeException("Movie with id "+movieId+" not found")))
				.flatMap(movie->{
					return this.movieRepository
							.deleteById(movieId)
							.thenReturn(movie);
									
				})
				.map(model->this.mapper.map(model, MovieDto.class));
	}
	@Override
	public Mono<MovieDto> assignActorToMovie(String movieId, String actorId) {
		return this.movieRepository
				.findById(movieId)
				.switchIfEmpty(Mono.error(new RuntimeException("Movie with id "+movieId+" not found")))
				.flatMap(movie->{
					return this.actorRepository
							.findById(actorId)
							.switchIfEmpty(Mono.error(new RuntimeException("Actor with id "+actorId+" not found")))
							.flatMap(actorModel-> {
								movie.getActors().add(actorModel);
								return this.movieRepository.save(movie);
							});
				})
				.map(model->this.mapper.map(model, MovieDto.class));
	}
	@Override
	public Flux<MovieDto> getMovieWithAverageRatingGte(double rating) {
		return this.reviewRepository
			.findAll()
			.groupBy(review->review.getMovie().getId())
			.flatMap(group->{ //movieId, review list[]
				log.info("Movie Key "+group.key() );
				group
					//.reduce(null, null)
					.collectList()
					.map(reviews->{
						log.info("Reviews "+reviews );
						return reviews;
					}).subscribe();
				return Mono.empty();
			});
		//return null;
	}
}
