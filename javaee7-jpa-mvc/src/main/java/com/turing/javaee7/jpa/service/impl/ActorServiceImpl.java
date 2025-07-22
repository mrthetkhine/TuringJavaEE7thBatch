package com.turing.javaee7.jpa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.javaee7.jpa.common.Mapper;
import com.turing.javaee7.jpa.controller.rest.exception.NotFoundException;
import com.turing.javaee7.jpa.dao.ActorDao;
import com.turing.javaee7.jpa.dto.ActorDto;
import com.turing.javaee7.jpa.model.entity.Actor;
import com.turing.javaee7.jpa.model.entity.Gender;
import com.turing.javaee7.jpa.service.ActorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ActorServiceImpl implements ActorService{
	
	@Autowired
	ActorDao actorDao;
	
	@Autowired
	Mapper mapper;
	
	@Override
	public List<ActorDto> getAllActors() {
		List<Actor> actors = this.actorDao.findAll();
		
		return mapper.mapList(actors, ActorDto.class);
	}

	@Override
	public ActorDto getActorById(Long actorId) throws NotFoundException {
		Optional<Actor> actorResult = this.actorDao.findById(actorId);
		if(actorResult.isPresent())
		{
			ActorDto actor = this.mapper.map(actorResult.get(), ActorDto.class);
			return actor;
		}
		else
		{
			throw new NotFoundException("Actor with id "+actorId+ " not found");
		}
	}

	@Override
	public ActorDto saveActor(ActorDto actorDto) {
		log.info("Save actor");
		Actor actor = this.mapper.map(actorDto, Actor.class);
		this.actorDao.save(actor);
		
		ActorDto savedActor = this.mapper.map(actor, ActorDto.class);
		return savedActor;
	}

	@Override
	public ActorDto updateActor(ActorDto actorDto)throws NotFoundException {
		Optional<Actor> actorResult = this.actorDao.findById(actorDto.getId());
		if(actorResult.isPresent())
		{
			Actor actor = actorResult.get();
			
			actor.setFirstName(actorDto.getFirstName());
			actor.setLastName(actorDto.getLastName());
			actor.setGender(Gender.valueOf(actorDto.getGender()));
			
			this.actorDao.save(actor);
			
			ActorDto updateDto = this.mapper.map(actor, ActorDto.class);
			return updateDto;
		}
		else
		{
			throw new NotFoundException("Actor with id "+actorDto.getId()+ " not found");
		}
	}

	@Override
	public ActorDto deleteActorById(Long actorId) throws NotFoundException {
		Optional<Actor> actorResult = this.actorDao.findById(actorId);
		if(actorResult.isPresent())
		{
			Actor actor = actorResult.get();
			ActorDto deletedDto = this.mapper.map(actor, ActorDto.class);
			
			this.actorDao.deleteById(actorId);
			return deletedDto;
		}
		else
		{
			throw new NotFoundException("Actor with id "+actorId+ " not found");
		}
	}

}
