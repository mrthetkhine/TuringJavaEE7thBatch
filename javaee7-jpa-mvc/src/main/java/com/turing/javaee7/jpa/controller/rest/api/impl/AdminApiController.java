package com.turing.javaee7.jpa.controller.rest.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turing.javaee7.jpa.controller.rest.common.ApiSuccessResponse;
import com.turing.javaee7.jpa.controller.rest.common.ApiUtil;
import com.turing.javaee7.jpa.controller.rest.common.SuccessCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/admin")
public class AdminApiController {
	@Autowired
	ApiUtil apiUtil;
	
	
	@GetMapping
	public ResponseEntity<ApiSuccessResponse< String>> getAdminData() {
		log.info("Admin API ");
		/*
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		log.info("Loggined username "+currentPrincipalName);
		log.info("User has authorities: " + userDetails.getAuthorities());
		
		*/
		return apiUtil.buildSucessResponse(HttpStatus.OK, 
				SuccessCode.SUCESS.toString(), "Get all movies ", "Admin Data");
	}
}
