package com.turing.javaee7.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.javaee7.jpa.common.Mapper;
import com.turing.javaee7.jpa.dto.ActorDto;
import com.turing.javaee7.jpa.model.Actor;
import com.turing.javaee7.jpa.repository.ActorRepository;
import com.turing.javaee7.jpa.service.ActorService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

	@Override
	public Mono<ActorDto> getActorById(String actorId) {
		
		return this.actorRepository.findById(actorId)
					.switchIfEmpty(Mono.error(new RuntimeException("Actor id "+actorId+" not found")))
					.map(actor->this.mapper.map(actor, ActorDto.class));
	}

	@Override
	public Mono<ActorDto> saveActor(ActorDto actorDto) {
		
		Actor actorModel = this.mapper.map(actorDto, Actor.class);
		
		return this.actorRepository
						.save(actorModel)
						.map(actor->this.mapper.map(actor, ActorDto.class));
	}

	@Override
	public Mono<ActorDto> updateActor(ActorDto actorDto) {
		return this.actorRepository
					.findById(actorDto.getId())
					.switchIfEmpty(Mono.error(new RuntimeException("Actor id "+actorDto.getId()+" not found")))
					.flatMap(actorModel->{
						actorModel.setFirstName(actorDto.getFirstName());
						actorModel.setLastName(actorDto.getLastName());
						actorModel.setGender(actorDto.getGender());
						return this.actorRepository.save(actorModel);
					})
					.map(model->this.mapper.map(model, ActorDto.class));
	}

	@Override
	public Mono<ActorDto> deleteActorById(String actorId) {
		return this.actorRepository
				.findById(actorId)
				.switchIfEmpty(Mono.error(new RuntimeException("Actor id "+actorId+" not found")))
				.flatMap(actorModel->{
					return this.actorRepository
							.deleteById(actorId)
							.thenReturn(actorModel);
				})
				.map(model->this.mapper.map(model, ActorDto.class));
	}

}
