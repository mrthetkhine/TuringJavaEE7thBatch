package com.turing.javaee7.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.javaee7.jpa.common.Mapper;
import com.turing.javaee7.jpa.dto.ReviewDto;
import com.turing.javaee7.jpa.model.Review;
import com.turing.javaee7.jpa.repository.MovieRepository;
import com.turing.javaee7.jpa.repository.ReviewRepository;
import com.turing.javaee7.jpa.service.ReviewService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	Mapper mapper;
	
	@Override
	public Mono<ReviewDto> saveReview(ReviewDto reviewDto) {
		
		return this.movieRepository	
					.findById(reviewDto.getMovieId())
					.switchIfEmpty(Mono.error(new RuntimeException("Movie with id "+reviewDto.getMovieId()+" Not found")))
					.flatMap(movie->{
						Review review = this.mapper.map(reviewDto, Review.class);
						review.setMovie(movie);
						
						return this.reviewRepository.save(review);
					})
					.map(model->this.mapper.map(model, ReviewDto.class));
	}

	@Override
	public Flux<ReviewDto> getReviewByMovie(String movieId) {
		
		return this.reviewRepository
					.findReviewByMovieId(movieId)
					.switchIfEmpty(Mono.error(new RuntimeException("Movie with id "+movieId+" Not found")))
					.map(model->this.mapper.map(model, ReviewDto.class));
				
	}

	@Override
	public Mono<ReviewDto> getReviweById(String reviewId) {
		return this.reviewRepository
					.findById(reviewId)
					.switchIfEmpty(Mono.error(new RuntimeException("Review with id "+reviewId+" Not found")))
					.map(model->this.mapper.map(model, ReviewDto.class));
	}

	@Override
	public Mono<ReviewDto> updateReview(ReviewDto reviewDto) {
		return this.reviewRepository	
				.findById(reviewDto.getId())
				.switchIfEmpty(Mono.error(new RuntimeException("Review with id "+reviewDto.getId()+" Not found")))
				.flatMap(review->{
					review.setReview(reviewDto.getReview());
					review.setRating(reviewDto.getRating());
					return this.reviewRepository.save(review);
				})
				.map(model->this.mapper.map(model, ReviewDto.class));
	}

	@Override
	public Mono<ReviewDto> deleteReviewById(String reviewId) {
		
		return this.reviewRepository	
				.findById(reviewId)
				.switchIfEmpty(Mono.error(new RuntimeException("Review with id "+reviewId+" Not found")))
				.flatMap(review->{
					return this.reviewRepository
								.deleteById(reviewId)
								.thenReturn(review);
				})
				.map(model->this.mapper.map(model, ReviewDto.class));
	}

}
