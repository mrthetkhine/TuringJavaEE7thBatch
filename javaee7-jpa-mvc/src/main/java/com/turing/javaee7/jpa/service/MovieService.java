package com.turing.javaee7.jpa.service;
import java.util.List;

import com.turing.javaee7.jpa.controller.rest.exception.NotFoundException;
import com.turing.javaee7.jpa.dto.*;
public interface MovieService {
	List<MovieDto> getAllMovies();
	MovieDto getMovieById(Long movieId)throws NotFoundException;
	MovieDto saveMovie(MovieDto movieDto);
	MovieDto updateMovie(MovieDto movieDto) throws NotFoundException;
	MovieDto deleteMovieById(Long movieId) throws NotFoundException;
}
