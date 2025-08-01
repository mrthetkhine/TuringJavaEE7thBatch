package com.turing.javaee7.jpa.controller.rest.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turing.javaee7.jpa.controller.rest.api.MovieApi;
import com.turing.javaee7.jpa.controller.rest.exception.BeanValidationException;
import com.turing.javaee7.jpa.controller.rest.exception.NotFoundException;
import com.turing.javaee7.jpa.dto.ActorDto;
import com.turing.javaee7.jpa.dto.MovieDto;
import com.turing.javaee7.jpa.service.MovieService;

import jakarta.validation.Valid;

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
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		log.info("Loggined username "+currentPrincipalName);
		log.info("User has authorities: " + userDetails.getAuthorities());
		
		List<MovieDto> movies =this.movieService.getAllMovies();
		return apiUtil.buildSucessResponse(HttpStatus.OK, 
				SuccessCode.SUCESS.toString(), "Get all movies ", movies);
	}

	@Override
	public ResponseEntity<ApiSuccessResponse<MovieDto>> getMovieById(Long movieId) throws NotFoundException {
	
		log.info("getMovie By Id ");
		MovieDto movieDto = this.movieService.getMovieById(movieId);
		return apiUtil.buildSucessResponse(HttpStatus.OK, SuccessCode.SUCESS.toString(), "Get movie byID ", movieDto);
	
	}

	@Override
	public ResponseEntity<ApiSuccessResponse<MovieDto>> createMovie(@Valid MovieDto movieDto, BindingResult bindingResult)
			throws BeanValidationException {
		if(bindingResult.hasErrors())
		{
			throw new BeanValidationException(bindingResult.getAllErrors());
		}
		else
		{
			MovieDto savedMovie = this.movieService.saveMovie(movieDto);
			return apiUtil.buildSucessResponse(HttpStatus.CREATED, SuccessCode.SUCESS.toString(), "Save movie ", savedMovie);
		}
		
	}

	@Override
	public ResponseEntity<ApiSuccessResponse<MovieDto>> updateMovie(Long movieId, @Valid MovieDto movieDto,
			BindingResult bindingResult) throws NotFoundException, BeanValidationException {
		if(bindingResult.hasErrors()){
			throw new BeanValidationException(bindingResult.getAllErrors());
		}
		else
		{
			movieDto.setId(movieId);
			MovieDto updatedMovie = this.movieService.updateMovie(movieDto);
			return apiUtil.buildSucessResponse(HttpStatus.OK, SuccessCode.SUCESS.toString(), "Updated movie ", updatedMovie);
		}
		
	}

	@Override
	public ResponseEntity<ApiSuccessResponse<MovieDto>> deleteMovieById(Long movieId) throws NotFoundException {
		MovieDto movieDto = this.movieService.deleteMovieById(movieId);
		return apiUtil.buildSucessResponse(HttpStatus.OK, SuccessCode.SUCESS.toString(), "Delete movie byID ", movieDto);
	}

	@Override
	public ResponseEntity<ApiSuccessResponse<List<ActorDto>>> getActorsInMovie(Long movieId) throws NotFoundException {
		List<ActorDto> actors = this.movieService.getActorsInMovie(movieId);
		return apiUtil.buildSucessResponse(HttpStatus.OK, 
				SuccessCode.SUCESS.toString(), "Get all actor in movie ", actors);
	}

	@Override
	public ResponseEntity<ApiSuccessResponse<ActorDto>> assignActorToMovie(Long movieId,Long actorId) throws NotFoundException {
		ActorDto actorDto = this.movieService.assignActorToMovie(movieId, actorId);
		return apiUtil.buildSucessResponse(HttpStatus.OK, 
				SuccessCode.SUCESS.toString(), "Assigned actor to movie ", actorDto);
	}

}
