package com.turing.javaee7.jpa.controller.rest.common;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;



import lombok.Data;

@Data
public class ApiErrorResponse  extends ApiResponse{
	
    private List<String> errors;

    public ApiErrorResponse(HttpStatus status, String errorCode, String message, List<String> errors) {
        super(status,errorCode,message);
    
        this.errors = errors;
    }

    public ApiErrorResponse(HttpStatus status, String errorCode, String message, String error) {
        super(status,errorCode,message);

        errors = Arrays.asList(error);
    }
}