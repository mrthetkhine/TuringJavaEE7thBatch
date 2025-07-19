package com.turing.javaee7.jpa.controller.rest.common;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiSuccessResponse<T> extends ApiResponse{

    private T data;

    public ApiSuccessResponse(HttpStatus status, String code, String message,T data) {
     
    	super(status,code,message);
        this.data = data;
       
    }

   
}
