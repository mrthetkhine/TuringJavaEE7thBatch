package com.turing.javaee7.jpa.controller.rest.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.turing.javaee7.jpa.controller.rest.api.MovieApi;
import com.turing.javaee7.jpa.controller.rest.common.ApiUtil;
import com.turing.javaee7.jpa.controller.rest.exception.NotFoundException;
import com.turing.javaee7.jpa.dto.MovieDto;
import com.turing.javaee7.jpa.service.MovieService;
import com.turing.javaee7.jpa.controller.rest.common.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MovieApiController implements MovieApi{

	@Autowired
	MovieService movieService;
	
	@Autowired
	ApiUtil apiUtil;
	
	@Override
	public ResponseEntity<ApiSuccessResponse< List<MovieDto>>> getAllMovies() {
		
		List<MovieDto> movies =this.movieService.getAllMovies();
		return apiUtil.buildSucessResponse(HttpStatus.OK, 
				SuccessCode.SUCESS.toString(), "Get all movies ", movies);
	}

	@Override
	public ResponseEntity<ApiSuccessResponse<MovieDto>> getMovieById(Long movieId) throws NotFoundException {
	
		MovieDto movieDto = this.movieService.getMovieById(movieId);
		return apiUtil.buildSucessResponse(HttpStatus.OK, SuccessCode.SUCESS.toString(), "Get movie byID ", movieDto);
	
	}

}
