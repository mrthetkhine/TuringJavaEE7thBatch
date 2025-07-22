package com.turing.javaee7.jpa.controller.rest.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import com.turing.javaee7.jpa.controller.rest.api.ActorApi;
import com.turing.javaee7.jpa.controller.rest.common.ApiSuccessResponse;
import com.turing.javaee7.jpa.controller.rest.common.ApiUtil;
import com.turing.javaee7.jpa.controller.rest.common.SuccessCode;
import com.turing.javaee7.jpa.controller.rest.exception.BeanValidationException;
import com.turing.javaee7.jpa.controller.rest.exception.NotFoundException;
import com.turing.javaee7.jpa.dto.ActorDto;
import com.turing.javaee7.jpa.dto.MovieDto;
import com.turing.javaee7.jpa.service.ActorService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ActorApiController implements ActorApi{
	
	@Autowired
	ActorService actorService;
	
	@Autowired
	ApiUtil apiUtil;
	
	@Override
	public ResponseEntity<ApiSuccessResponse<List<ActorDto>>> getAllActors() {
		List<ActorDto> actors = this.actorService.getAllActors();
		
		return apiUtil.buildSucessResponse(HttpStatus.OK, 
				SuccessCode.SUCESS.toString(), "Get all actros ", actors);
	}

	@Override
	public ResponseEntity<ApiSuccessResponse<ActorDto>> getActorById(Long actorId) throws NotFoundException {
	
		ActorDto actor = this.actorService.getActorById(actorId);
		return apiUtil.buildSucessResponse(HttpStatus.OK, 
				SuccessCode.SUCESS.toString(), "Get actor by ID ", actor);
	}

	@Override
	public ResponseEntity<ApiSuccessResponse<ActorDto>> saveActor(@Valid ActorDto actorDo, BindingResult bindingResult)
			throws BeanValidationException {
		if(bindingResult.hasErrors())
		{
			throw new BeanValidationException(bindingResult.getAllErrors());
		}
		else
		{
			ActorDto savedActor = this.actorService.saveActor(actorDo);
			return apiUtil.buildSucessResponse(HttpStatus.CREATED, SuccessCode.SUCESS.toString(), "Save Actor ", savedActor);
		}
	}

	@Override
	public ResponseEntity<ApiSuccessResponse<ActorDto>> updateActor(Long actorId, @Valid ActorDto actorDto,
			BindingResult bindingResult) throws NotFoundException, BeanValidationException {
		if(bindingResult.hasErrors())
		{
			throw new BeanValidationException(bindingResult.getAllErrors());
		}
		else
		{
			actorDto.setId(actorId);
			ActorDto savedActor = this.actorService.updateActor(actorDto);
			return apiUtil.buildSucessResponse(HttpStatus.OK, SuccessCode.SUCESS.toString(), "Update Actor ", savedActor);
		}
	}

	@Override
	public ResponseEntity<ApiSuccessResponse<ActorDto>> deleteActorById(Long actorId) throws NotFoundException {
		ActorDto deletedActor = this.actorService.deleteActorById(actorId);
		return apiUtil.buildSucessResponse(HttpStatus.OK, SuccessCode.SUCESS.toString(), "Deleted Actor ", deletedActor);
	}

}
