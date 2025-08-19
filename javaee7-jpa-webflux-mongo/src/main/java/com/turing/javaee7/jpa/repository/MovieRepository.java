package com.turing.javaee7.jpa.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


import com.turing.javaee7.jpa.model.Movie;

public interface MovieRepository  extends ReactiveMongoRepository<Movie,String>{

}
