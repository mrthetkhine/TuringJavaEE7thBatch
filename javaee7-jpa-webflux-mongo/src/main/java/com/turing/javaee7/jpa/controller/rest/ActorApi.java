package com.turing.javaee7.jpa.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turing.javaee7.jpa.common.ResponseUtil;
import com.turing.javaee7.jpa.dto.ActorDto;
import com.turing.javaee7.jpa.dto.RestResponse;
import com.turing.javaee7.jpa.service.ActorService;

import jakarta.validation.Valid;
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
	Mono<ResponseEntity<RestResponse>> getAllActor()
	{
		return this.actorService.getAllActor()
								.collectList()
								.flatMap(data->responseUtil.succesResponse(HttpStatus.OK, "Success", data));
	}
	@GetMapping(value="/{actorId}")
	Mono<ResponseEntity<RestResponse>> getActorById(@PathVariable String actorId)
	{
		return this.actorService.getActorById(actorId)
								.flatMap(data->responseUtil.succesResponse(HttpStatus.OK, "Success", data))
								.onErrorResume(ae->responseUtil.errorResponse(HttpStatus.NOT_FOUND, ae.getMessage(), ae.getLocalizedMessage()));
	}

	@PostMapping
	Mono<ResponseEntity<RestResponse>> saveActor(@Valid @RequestBody Mono<ActorDto> dto)
	{
		return dto 
				.flatMap(actorDto->this.actorService.saveActor(actorDto))
				.flatMap(data->responseUtil.succesResponse(HttpStatus.CREATED, "Success", data));
	}
	@PutMapping(value="/{actorId}")
	Mono<ResponseEntity<RestResponse>> updateActorById(@PathVariable String actorId,@Valid @RequestBody Mono<ActorDto> dto)
	{
		
		return dto 
				.flatMap(actorDto->{
					actorDto.setId(actorId);
					return this.actorService.updateActor(actorDto);
				})
				.flatMap(data->responseUtil.succesResponse(HttpStatus.OK, "Success", data))
				.onErrorResume(ae->responseUtil.errorResponse(HttpStatus.NOT_FOUND, ae.getMessage(), ae.getLocalizedMessage()));
				
	}
	@DeleteMapping(value="/{actorId}")
	Mono<ResponseEntity<RestResponse>> deleteActorById(@PathVariable String actorId)
	{
		
		return this.actorService.deleteActorById(actorId)
				.flatMap(data->responseUtil.succesResponse(HttpStatus.OK, "Success", data))
				.onErrorResume(ae->responseUtil.errorResponse(HttpStatus.NOT_FOUND, ae.getMessage(), ae.getLocalizedMessage()));
				
	}
}
