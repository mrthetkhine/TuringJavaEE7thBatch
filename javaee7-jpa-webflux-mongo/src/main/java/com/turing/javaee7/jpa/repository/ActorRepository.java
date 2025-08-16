package com.turing.javaee7.jpa.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.turing.javaee7.jpa.model.Actor;

public interface ActorRepository extends ReactiveMongoRepository<Actor,String>{

}
