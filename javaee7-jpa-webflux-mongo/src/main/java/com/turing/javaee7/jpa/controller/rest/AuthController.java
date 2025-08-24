package com.turing.javaee7.jpa.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turing.javaee7.jpa.common.ResponseUtil;
import com.turing.javaee7.jpa.dto.RestResponse;
import com.turing.javaee7.jpa.model.User;
import com.turing.javaee7.jpa.service.AuthService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api")
public class AuthController {

	@Autowired
	AuthService authService;
	
	@Autowired
	ResponseUtil responseUtil;
	
	@PostMapping("/login")
	Mono<ResponseEntity<RestResponse>> login(@Valid @RequestBody User user)
	{
		log.info("Login ",user);
		return this.authService.login(user)
					.flatMap(response->responseUtil.succesResponse(HttpStatus.OK,"Success",response))
					.onErrorResume(err->responseUtil.errorResponse(HttpStatus.UNAUTHORIZED,"Invalid credential ",err.getMessage()));
	}
	
	@PostMapping("/register")
	Mono<ResponseEntity<RestResponse>> register(@Valid @RequestBody User user)
	{
		log.info("Register "+user.getUsername());
		return this.authService.register(user)
					.flatMap(response->responseUtil.succesResponse(HttpStatus.CREATED,"Success",response))
					.onErrorResume(err->responseUtil.errorResponse(HttpStatus.UNAUTHORIZED,"Invalid credential ",err.getMessage()));
	}
	
}
