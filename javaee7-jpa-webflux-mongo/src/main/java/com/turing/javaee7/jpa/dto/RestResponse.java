package com.turing.javaee7.jpa.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestResponse<T> {
	String code;
	String message;
	Object error;
	T data;
	
	
}
