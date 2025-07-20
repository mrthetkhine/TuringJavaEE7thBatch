package com.turing.javaee7.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.javaee7.jpa.common.Mapper;
import com.turing.javaee7.jpa.dao.ActorDao;
import com.turing.javaee7.jpa.dto.ActorDto;
import com.turing.javaee7.jpa.model.entity.Actor;
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

}
