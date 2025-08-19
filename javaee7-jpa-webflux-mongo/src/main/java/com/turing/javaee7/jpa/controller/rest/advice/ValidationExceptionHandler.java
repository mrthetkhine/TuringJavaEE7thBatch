package com.turing.javaee7.jpa.controller.rest.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;

import com.turing.javaee7.jpa.common.ResponseUtil;
import com.turing.javaee7.jpa.dto.RestResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@ControllerAdvice
public class ValidationExceptionHandler {
	@Autowired
	ResponseUtil responseUtil;
	
	@ExceptionHandler(WebExchangeBindException.class)
    public Mono<ResponseEntity<RestResponse>> handleException(WebExchangeBindException e) {
        var errors = e.getBindingResult().getAllErrors();
        return responseUtil.validationErrorResponse(HttpStatus.BAD_REQUEST, "Validation Error", errors);
    }

}
