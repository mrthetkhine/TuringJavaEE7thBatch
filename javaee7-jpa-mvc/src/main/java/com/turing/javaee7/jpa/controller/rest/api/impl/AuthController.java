package com.turing.javaee7.jpa.controller.rest.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.turing.javaee7.jpa.dto.UserDto;
import com.turing.javaee7.jpa.service.AuthService;


@RestController
@RequestMapping(path = "/api/auth")
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	@GetMapping(value="/hello")
	String hello()
	{
		try
		{
			Thread.sleep(6000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Hello";
	}
	
	@PostMapping(path = "/register")
	@ResponseStatus(HttpStatus.NO_CONTENT)
    public void register(@RequestBody UserDto registerRequest) throws Exception {
        authService.register(registerRequest);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody UserDto loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

}
