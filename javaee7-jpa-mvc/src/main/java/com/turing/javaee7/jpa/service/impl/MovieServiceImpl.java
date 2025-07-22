package com.turing.javaee7.jpa.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.javaee7.jpa.common.Mapper;
import com.turing.javaee7.jpa.controller.rest.exception.NotFoundException;
import com.turing.javaee7.jpa.dao.ActorDao;
import com.turing.javaee7.jpa.dao.MovieRepository;
import com.turing.javaee7.jpa.dto.ActorDto;
import com.turing.javaee7.jpa.dto.MovieDto;
import com.turing.javaee7.jpa.model.entity.Actor;
import com.turing.javaee7.jpa.model.entity.Movie;
import com.turing.javaee7.jpa.model.entity.MovieDetails;
import com.turing.javaee7.jpa.service.MovieService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	ActorDao actorDao;
	
	@Autowired
	Mapper mapper;
	
	@Override
	public List<MovieDto> getAllMovies() {
		List<Movie> movies = this.movieRepository.getAllMovie();
		return mapper.mapList(movies, MovieDto.class);
	}

	@Override
	public MovieDto getMovieById(Long movieId) throws NotFoundException {
		Optional<Movie> movie = this.movieRepository.findById(movieId);
		if(movie.isPresent())
		{
			return mapper.map(movie.get(), MovieDto.class);
		}
		else
		{
			throw new NotFoundException("Movie ID "+movieId+" Not found");
		}
	}

	@Override
	public MovieDto saveMovie(MovieDto movieDto) {
		Movie movie = this.mapper.map(movieDto, Movie.class);
		log.info("Save movie details "+movie.getMovieDetails().getDetails());
		
		MovieDetails movieDetails = movie.getMovieDetails();
		movieDetails.setMovie(movie);
		
		movie = this.movieRepository.save(movie);
		
		MovieDto result= this.mapper.map(movie, MovieDto.class);
		return result;
	}

	@Override
	public MovieDto updateMovie(MovieDto movieDto) throws NotFoundException {
		Optional<Movie> movieResult = this.movieRepository.findById(movieDto.getId());
		if(movieResult.isPresent())
		{
			Movie movie = movieResult.get();
			movie.setGenre(movieDto.getGenre());
			movie.setTitle(movieDto.getTitle());
			movie.setYear(movieDto.getYear());
			
			this.movieRepository.save(movie);
			MovieDetails movieDetails = movie.getMovieDetails();
			
			movieDetails.setDetails(movieDto.getMovieDetails().getDetails());

			return mapper.map(movie, MovieDto.class);
		}
		else
		{
			throw new NotFoundException("Movie ID "+movieDto.getId()+" Not found");
		}
		
	}

	@Override
	public MovieDto deleteMovieById(Long movieId) throws NotFoundException {
		Optional<Movie> movieResult = this.movieRepository.findById(movieId);
		if(movieResult.isPresent())
		{
			Movie movie = movieResult.get();
			
			this.movieRepository.deleteById(movieId);
			
			MovieDto dto = this.mapper.map(movie, MovieDto.class);
			return dto;
		}
		else
		{
			throw new NotFoundException("Movie ID "+movieId+" Not found");
		}
		
	}

	@Override
	public List<ActorDto> getActorsInMovie(Long movieId) throws NotFoundException {
		Optional<Movie> movieResult = this.movieRepository.findById(movieId);
		if(movieResult.isPresent())
		{
			Movie movie = movieResult.get();
			Set<Actor> actors =  movie.getActors();
			
			ArrayList<Actor> actorList= new ArrayList<>();
			for(Actor act : actors)
			{
				actorList.add(act);
			}
			return this.mapper.mapList(actorList, ActorDto.class);
		}
		else
		{
			throw new NotFoundException("Movie ID "+movieId+" Not found");
		}
	}

	@Override
	public ActorDto assignActorToMovie(Long movieId, Long actorId) throws NotFoundException {
		Optional<Movie> movieResult = this.movieRepository.findById(movieId);
		if(movieResult.isPresent())
		{
			Optional<Actor> actorResult = this.actorDao.findById(actorId);
			if(actorResult.isPresent())
			{
				Movie movie = movieResult.get();
				Actor actor =  actorResult.get();
				
				movie.getActors().add(actor);
				actor.getMovies().add(movie);
				
				this.movieRepository.save(movie);
				return this.mapper.map(actor, ActorDto.class);
			}
			else
			{
				throw new NotFoundException("Movie ID "+movieId+" Not found");
			}
			
		}
		else
		{
			throw new NotFoundException("Movie ID "+movieId+" Not found");
		}
	}
	
	
}
