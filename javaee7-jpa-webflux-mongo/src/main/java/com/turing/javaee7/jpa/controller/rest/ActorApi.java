package com.turing.javaee7.jpa.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turing.javaee7.jpa.common.ResponseUtil;
import com.turing.javaee7.jpa.dto.ActorDto;
import com.turing.javaee7.jpa.dto.RestResponse;
import com.turing.javaee7.jpa.service.ActorService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/actors")
public class ActorApi {
	
	@Autowired
	ActorService actorService;
	
	@Autowired
	ResponseUtil responseUtil;
	
	
	@GetMapping
	Mono<ResponseEntity<RestResponse<List<ActorDto>>>> getAllActor()
	{
		return this.actorService.getAllActor()
								.collectList()
								.flatMap(data->responseUtil.succesResponse(HttpStatus.OK, "Success", data));
	}
}
