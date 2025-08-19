package com.turing.javaee7.jpa.service;

import com.turing.javaee7.jpa.dto.ActorDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ActorService {
	Flux<ActorDto> getAllActor();
	Mono<ActorDto> getActorById(String actorId);
	Mono<ActorDto> saveActor(ActorDto actorDto);
	Mono<ActorDto> updateActor(ActorDto actorDto);
	Mono<ActorDto> deleteActorById(String actorId);
}
