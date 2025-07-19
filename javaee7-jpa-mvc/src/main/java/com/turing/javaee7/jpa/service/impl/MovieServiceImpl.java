package com.turing.javaee7.jpa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.javaee7.jpa.common.Mapper;
import com.turing.javaee7.jpa.dao.MovieRepository;
import com.turing.javaee7.jpa.dto.MovieDto;
import com.turing.javaee7.jpa.model.entity.Movie;
import com.turing.javaee7.jpa.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	Mapper mapper;
	
	@Override
	public List<MovieDto> getAllMovies() {
		List<Movie> movies = this.movieRepository.getAllMovie();
		return mapper.mapList(movies, MovieDto.class);
	}

	@Override
	public MovieDto getMovieById(Long movieId) {
		Optional<Movie> movie = this.movieRepository.findById(movieId);
		if(movie.isPresent())
		{
			return mapper.map(movie.get(), MovieDto.class);
		}
		else
		{
			return null;
		}
	}
	
}
