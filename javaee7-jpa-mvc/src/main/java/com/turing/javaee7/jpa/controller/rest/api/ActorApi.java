package com.turing.javaee7.jpa.controller.rest.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.turing.javaee7.jpa.controller.rest.common.ApiSuccessResponse;
import com.turing.javaee7.jpa.controller.rest.exception.BeanValidationException;
import com.turing.javaee7.jpa.controller.rest.exception.NotFoundException;
import com.turing.javaee7.jpa.dto.ActorDto;
import com.turing.javaee7.jpa.dto.MovieDto;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;


@RequestMapping("/api/actors")
public interface ActorApi {
	@GetMapping
	ResponseEntity<ApiSuccessResponse< List<ActorDto>>> getAllActors();
	
	@GetMapping(value = "/{actorId}")
	ResponseEntity<ApiSuccessResponse<ActorDto>> getActorById(@PathVariable Long actorId) throws NotFoundException ;
	
	@PostMapping
	ResponseEntity<ApiSuccessResponse<ActorDto>> saveActor(@Valid @RequestBody ActorDto actorDo, BindingResult result)throws BeanValidationException;
	
	@PutMapping(value = "/{actorId}")
	ResponseEntity<ApiSuccessResponse<ActorDto>> updateActor(@PathVariable Long actorId,
				@Valid @RequestBody ActorDto actorDto, 
				BindingResult result)throws NotFoundException, BeanValidationException;
	
	@DeleteMapping(value = "/{actorId}")
	ResponseEntity<ApiSuccessResponse<ActorDto>> deleteActorById(@PathVariable Long actorId) throws NotFoundException ;
	
	
}
