package com.turing.javaee7.jpa.service;

import java.util.List;

import com.turing.javaee7.jpa.controller.rest.exception.NotFoundException;
import com.turing.javaee7.jpa.dto.ActorDto;
import com.turing.javaee7.jpa.dto.MovieDto;

public interface ActorService {
	List<ActorDto> getAllActors();
	ActorDto getActorById(Long actorId) throws NotFoundException;
	ActorDto saveActor(ActorDto actorDto);
	ActorDto updateActor(ActorDto actorDto)throws NotFoundException;
	ActorDto deleteActorById(Long actorId)throws NotFoundException;
}
