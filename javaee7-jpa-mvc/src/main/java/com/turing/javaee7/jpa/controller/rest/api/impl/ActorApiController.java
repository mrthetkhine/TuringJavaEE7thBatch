package com.turing.javaee7.jpa.controller.rest.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.turing.javaee7.jpa.controller.rest.api.ActorApi;
import com.turing.javaee7.jpa.controller.rest.common.ApiSuccessResponse;
import com.turing.javaee7.jpa.controller.rest.common.ApiUtil;
import com.turing.javaee7.jpa.controller.rest.common.SuccessCode;
import com.turing.javaee7.jpa.dto.ActorDto;
import com.turing.javaee7.jpa.service.ActorService;

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

}
