package com.turing.javaee7.jpa.service;
import java.util.List;

import com.turing.javaee7.jpa.dto.*;
public interface MovieService {
	List<MovieDto> getAllMovies();
	MovieDto getMovieById(Long movieId);
}
