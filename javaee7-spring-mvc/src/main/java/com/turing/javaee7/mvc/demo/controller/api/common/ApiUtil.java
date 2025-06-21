package com.turing.javaee7.mvc.demo.controller.api.common;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.turing.javaee7.mvc.demo.controller.api.dto.ApiResponse;
import com.turing.javaee7.mvc.demo.controller.api.dto.SuccessCode;
import com.turing.javaee7.mvc.demo.dto.BookDto;

@Component
public class ApiUtil {
	public <T> ResponseEntity<ApiResponse<T>> buildSucessResponse(HttpStatus httpStatus,
			String code, String message, T body)
	{
		ApiResponse<T> response = new ApiResponse<T>(HttpStatus.OK,
				SuccessCode.SUCESS.toString(),message, body);
		 return new ResponseEntity<ApiResponse<T>>(
	  		      response, new HttpHeaders(), response.getStatus());
	}
}
