package com.turing.javaee7.jpa.controller.rest.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.turing.javaee7.jpa.controller.rest.common.ApiSuccessResponse;
import com.turing.javaee7.jpa.controller.rest.exception.NotFoundException;
import com.turing.javaee7.jpa.dto.MovieDto;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RequestMapping("/api/movies")
public interface MovieApi {
	@GetMapping
	ResponseEntity<ApiSuccessResponse< List<MovieDto>>> getAllMovies();
	
	@Operation(summary = "Get a movie by its id")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Found the book", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = MovieDto.class)) }),
			  @ApiResponse(responseCode = "400", description = "Invalid id supplied", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Movie not found", 
			    content = @Content) })
	@GetMapping(value = "/{movieId}")
	ResponseEntity<ApiSuccessResponse<MovieDto>> getMovieById(@PathVariable Long movieId) throws NotFoundException ;
	
}
