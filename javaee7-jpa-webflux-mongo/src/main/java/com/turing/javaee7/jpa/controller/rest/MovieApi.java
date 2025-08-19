package com.turing.javaee7.jpa.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turing.javaee7.jpa.common.ResponseUtil;
import com.turing.javaee7.jpa.dto.ActorDto;
import com.turing.javaee7.jpa.dto.MovieDto;
import com.turing.javaee7.jpa.dto.RestResponse;
import com.turing.javaee7.jpa.dto.ReviewDto;
import com.turing.javaee7.jpa.service.ActorService;
import com.turing.javaee7.jpa.service.MovieService;
import com.turing.javaee7.jpa.service.ReviewService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/movies")
public class MovieApi {
	@Autowired
	MovieService movieService;
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	ResponseUtil responseUtil;
	
	
	@GetMapping
	Mono<ResponseEntity<RestResponse>> getAllMovies()
	{
		return this.movieService.getAllMovies()
								.collectList()
								.flatMap(data->responseUtil.succesResponse(HttpStatus.OK, "Success", data));
	}
	@GetMapping(value="/{movieId}")
	Mono<ResponseEntity<RestResponse>> getMovieById(@PathVariable String movieId)
	{
		return this.movieService.getMovieById(movieId)
								.flatMap(data->responseUtil.succesResponse(HttpStatus.OK, "Success", data))
								.onErrorResume(ae->responseUtil.errorResponse(HttpStatus.NOT_FOUND, ae.getMessage(), ae.getLocalizedMessage()));
	}
	@PostMapping
	Mono<ResponseEntity<RestResponse>> saveMovie(@Valid @RequestBody Mono<MovieDto> dtoMono)
	{
		return dtoMono.flatMap(dto->this.movieService.saveMovie(dto))
					  .flatMap(data->responseUtil.succesResponse(HttpStatus.CREATED, "Success", data));
	}
	@PutMapping(value="/{movieId}")
	Mono<ResponseEntity<RestResponse>> updateMovie(@PathVariable String movieId,@Valid @RequestBody Mono<MovieDto> dtoMono)
	{
		return dtoMono.flatMap(dto->{
						dto.setId(movieId);
						return this.movieService.updateMovie(dto);
					})
				.flatMap(data->responseUtil.succesResponse(HttpStatus.OK, "Success", data))
				.onErrorResume(ae->responseUtil.errorResponse(HttpStatus.NOT_FOUND, ae.getMessage(), ae.getLocalizedMessage()));
	}
	@DeleteMapping(value="/{movieId}")
	Mono<ResponseEntity<RestResponse>> deleteMovieById(@PathVariable String movieId)
	{
		return this.movieService.deleteMovieById(movieId)
								.flatMap(data->responseUtil.succesResponse(HttpStatus.OK, "Success", data))
								.onErrorResume(ae->responseUtil.errorResponse(HttpStatus.NOT_FOUND, ae.getMessage(), ae.getLocalizedMessage()));
	}
	@PostMapping(value="/{movieId}/assignment/actors/{actorId}")
	Mono<ResponseEntity<RestResponse>> assignActorToMovie(@PathVariable String movieId,@PathVariable String actorId)
	{
		return this.movieService.assignActorToMovie(movieId, actorId)
					  .flatMap(data->responseUtil.succesResponse(HttpStatus.OK, "Success", data))
					  .onErrorResume(ae->responseUtil.errorResponse(HttpStatus.NOT_FOUND, ae.getMessage(), ae.getLocalizedMessage()));
	}
	@GetMapping(value="/{movieId}/reviews")
	Mono<ResponseEntity<RestResponse>> getAllReviewForMovieId(@PathVariable String movieId)
	{
		log.info("get review "+movieId);
		return this.reviewService
					  .getReviewByMovie(movieId)
					  .collectList()
					  .flatMap(data->responseUtil.succesResponse(HttpStatus.OK, "Success", data))
					  .onErrorResume(ae->responseUtil.errorResponse(HttpStatus.NOT_FOUND, ae.getMessage(), ae.getLocalizedMessage()));
	}
	
	@PostMapping(value="/{movieId}/reviews")
	Mono<ResponseEntity<RestResponse>> saveReview(@PathVariable String movieId,@Valid @RequestBody Mono<ReviewDto> dtoMono)
	{
		log.info("save review "+movieId);
		return dtoMono.flatMap(dto->{
							dto.setMovieId(movieId);
							return this.reviewService.saveReview(dto);
						})
					  .flatMap(data->responseUtil.succesResponse(HttpStatus.CREATED, "Success", data))
					  .onErrorResume(ae->responseUtil.errorResponse(HttpStatus.NOT_FOUND, ae.getMessage(), ae.getLocalizedMessage()));
	}
	@GetMapping(value="/reviews/{reviewId}")
	Mono<ResponseEntity<RestResponse>> reviewById(@PathVariable String reviewId)
	{
		log.info("get review "+reviewId);
		return this.reviewService
					  .getReviweById(reviewId)
					  .flatMap(data->responseUtil.succesResponse(HttpStatus.OK, "Success", data))
					  .onErrorResume(ae->responseUtil.errorResponse(HttpStatus.NOT_FOUND, ae.getMessage(), ae.getLocalizedMessage()));
	}
	@PutMapping(value="/reviews/{reviewId}")
	Mono<ResponseEntity<RestResponse>> updateReviewById(@PathVariable String reviewId,@Valid @RequestBody Mono<ReviewDto> dtoMono)
	{
		log.info("update review "+reviewId);
		return dtoMono.flatMap(dto->{
			dto.setId(reviewId);
			return this.reviewService.updateReview(dto);
		})
	  .flatMap(data->responseUtil.succesResponse(HttpStatus.OK, "Success", data))
	  .onErrorResume(ae->responseUtil.errorResponse(HttpStatus.NOT_FOUND, ae.getMessage(), ae.getLocalizedMessage()));
	}
	@DeleteMapping(value="/reviews/{reviewId}")
	Mono<ResponseEntity<RestResponse>> deleteReviewById(@PathVariable String reviewId)
	{
		log.info("update review "+reviewId);
		return this.reviewService
				.deleteReviewById(reviewId)
				.flatMap(data->responseUtil.succesResponse(HttpStatus.OK, "Success", data))
				.onErrorResume(ae->responseUtil.errorResponse(HttpStatus.NOT_FOUND, ae.getMessage(), ae.getLocalizedMessage()));
	}
}
