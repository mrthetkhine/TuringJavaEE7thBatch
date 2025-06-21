package com.turing.javaee7.mvc.demo.controller.api.dto;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiResponse<T> {
	private HttpStatus status;
	private String code;
    private String message;
    private T data;

    public ApiResponse(HttpStatus status, String code, String message,T data) {
        super();
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
       
    }

   
}
