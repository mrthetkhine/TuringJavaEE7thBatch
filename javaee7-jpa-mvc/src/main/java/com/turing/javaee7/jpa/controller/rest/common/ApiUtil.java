package com.turing.javaee7.jpa.controller.rest.common;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class ApiUtil {
	public <T> ResponseEntity<ApiSuccessResponse<T>> buildSucessResponse(HttpStatus httpStatus,
			String code, String message, T body)
	{
		ApiSuccessResponse<T> response = new ApiSuccessResponse<T>(HttpStatus.OK,
				SuccessCode.SUCESS.toString(),message, body);
		 return new ResponseEntity<ApiSuccessResponse<T>>(
	  		      response, new HttpHeaders(), response.getStatus());
	}
}
