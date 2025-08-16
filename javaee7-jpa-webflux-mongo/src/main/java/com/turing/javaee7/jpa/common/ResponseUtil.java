package com.turing.javaee7.jpa.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.util.List;
import com.turing.javaee7.jpa.dto.RestResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class ResponseUtil {
	
	public <T> Mono<ResponseEntity<RestResponse<T>>> succesResponse(HttpStatus statusCode, String message, T data)
	{
		log.info("Data "+ data);
		RestResponse<T> response =new RestResponse<T>();
		response.setMessage(message);
		response.setData(data);
		ResponseEntity re = ResponseEntity.status(statusCode)
								.body(response);
		return Mono.just(re);
		
	}
	
	public <T> Mono<ResponseEntity<RestResponse>> errorResponse(HttpStatus statusCode, String message, T error)
	{
		RestResponse<T> response =new RestResponse<T>();
		response.setMessage(message);
		response.setError(error);
		ResponseEntity re = ResponseEntity.status(statusCode)
								.body(response);
		return Mono.just(re);
		
	}
}
