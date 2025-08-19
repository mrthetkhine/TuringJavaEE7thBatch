package com.turing.javaee7.jpa.service;

import com.turing.javaee7.jpa.dto.ReviewDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReviewService {
	Flux<ReviewDto> getReviewByMovie(String movieId);
	Mono<ReviewDto> saveReview(ReviewDto reviewDto);
	Mono<ReviewDto> getReviweById(String reviewId);
	Mono<ReviewDto> updateReview(ReviewDto reviewDto);
	Mono<ReviewDto> deleteReviewById(String reviewId);
}
