package com.turing.javaee7.jpa.controller.rest.exception;

import java.util.List;

import org.springframework.validation.ObjectError;

import lombok.Data;

@Data
public class BeanValidationException extends Exception{
	List<ObjectError> errors;
	public BeanValidationException(List<ObjectError> errors)
	{
		this.errors = errors;
	}
}
