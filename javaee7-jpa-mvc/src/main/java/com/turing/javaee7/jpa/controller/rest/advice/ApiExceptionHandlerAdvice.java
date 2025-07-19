package com.turing.javaee7.jpa.controller.rest.advice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.turing.javaee7.jpa.controller.rest.exception.*;
import com.turing.javaee7.jpa.controller.rest.common.*;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandlerAdvice{
	
	@ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ne) {
        log.info("Not found exception handled "+ne.getMessage());
        String error = ne.getMessage(); 
        ApiErrorResponse apiError = 
  		      new ApiErrorResponse(HttpStatus.NOT_FOUND, ErrorCode.INVALID_BOOK_ID.toString(), ne.getLocalizedMessage(), error);
  		    return new ResponseEntity<Object>(
  		      apiError, new HttpHeaders(), apiError.getStatus());
    }
	@ResponseStatus(HttpStatus.BAD_REQUEST)  // 400
    @ExceptionHandler(BeanValidationException.class)
    public ResponseEntity<Object> handleBeanValidationError(BeanValidationException be) {
        log.info("Not found exception handled "+be.getMessage());
       
        log.info("BeanValidationException");
	    List<String> errorMessage =new ArrayList<String>();
	    for (ObjectError error : be.getErrors())
	    {
	    	errorMessage.add(error.getDefaultMessage());
	    }

	    ApiErrorResponse apiError = 
  		      new ApiErrorResponse(HttpStatus.BAD_REQUEST, ErrorCode.BEAN_VALIDATION_ERROR.toString(), be.getLocalizedMessage(), errorMessage);
  		    return new ResponseEntity<Object>(
  		      apiError, new HttpHeaders(), apiError.getStatus());
    }
}
