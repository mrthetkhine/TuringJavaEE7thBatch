package com.turing.javaee7.jpa.service;

import com.turing.javaee7.jpa.dto.ActorDto;

import reactor.core.publisher.Flux;

public interface ActorService {
	Flux<ActorDto> getAllActor();
}
