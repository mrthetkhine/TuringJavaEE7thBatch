package com.turing.javaee7.jpa.controller.rest.common;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ApiResponse {
	private HttpStatus status;
	private String code;
    private String message;
    private Date responseAt;
    
    public ApiResponse(HttpStatus status,String code, String message)
    {
    	this.status = status;
    	this.code = code;
    	this.message= message;
    	this.responseAt = new Date();
    }

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getResponseAt() {
		return responseAt;
	}

	public void setResponseAt(Date responseAt) {
		this.responseAt = responseAt;
	}
    
}
