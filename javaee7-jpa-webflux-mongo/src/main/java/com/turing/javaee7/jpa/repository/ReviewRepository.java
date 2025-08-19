package com.turing.javaee7.jpa.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.turing.javaee7.jpa.model.Movie;
import com.turing.javaee7.jpa.model.Review;

import reactor.core.publisher.Flux;

public interface ReviewRepository extends ReactiveMongoRepository<Review,String>{
	@Query("{ 'movie': ?0}")
	Flux<Review> findReviewByMovieId(String movie);
}
