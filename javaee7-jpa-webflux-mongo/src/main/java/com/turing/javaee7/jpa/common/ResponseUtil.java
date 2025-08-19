package com.turing.javaee7.jpa.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;
import com.turing.javaee7.jpa.dto.RestResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class ResponseUtil {
	
	public Mono<ResponseEntity<RestResponse>> succesResponse(HttpStatus statusCode, String message, Object data)
	{
		RestResponse response =new RestResponse();
		response.setMessage(message);
		response.setData(data);
		ResponseEntity re = ResponseEntity.status(statusCode)
								.body(response);
		return Mono.just(re);
		
	}
	public Mono<ResponseEntity<RestResponse>> errorResponse(HttpStatus statusCode, String message, Object error)
	{
		RestResponse response =new RestResponse();
		response.setMessage(message);
		response.setError(error);
		ResponseEntity re = ResponseEntity.status(statusCode)
								.body(response);
		return Mono.just(re);
		
	}
	public Mono<ResponseEntity<RestResponse>> validationErrorResponse(HttpStatus statusCode, String message,List<ObjectError> errors)
	{
		 List<String> errorMessage =new ArrayList<String>();
	    for (ObjectError error : errors)
	    {
	    	errorMessage.add(error.getDefaultMessage());
	    }
		RestResponse response =new RestResponse();
		response.setMessage(message);
		response.setError(errorMessage);
		ResponseEntity re = ResponseEntity.status(statusCode)
								.body(response);
		return Mono.just(re);
		
	}
}
