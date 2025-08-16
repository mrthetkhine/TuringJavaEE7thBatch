package com.turing.javaee7.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.javaee7.jpa.common.Mapper;
import com.turing.javaee7.jpa.dto.ActorDto;
import com.turing.javaee7.jpa.repository.ActorRepository;
import com.turing.javaee7.jpa.service.ActorService;

import reactor.core.publisher.Flux;

@Service
public class ActorServiceImpl implements ActorService {
	
	@Autowired
	ActorRepository actorRepository;

	@Autowired
	Mapper mapper;
	
	@Override
	public Flux<ActorDto> getAllActor() {
		return this.actorRepository
					.findAll()
					.map(actor->this.mapper.map(actor, ActorDto.class));
				
	}

}
