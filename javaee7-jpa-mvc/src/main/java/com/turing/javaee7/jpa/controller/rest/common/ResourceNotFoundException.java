package com.turing.javaee7.jpa.controller.rest.common;

public class ResourceNotFoundException extends RuntimeException{

	String message;
	ResourceNotFoundException(String message)
	{
		this.message = message;
	}
}
