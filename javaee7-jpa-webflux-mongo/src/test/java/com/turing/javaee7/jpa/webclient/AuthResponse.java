package com.turing.javaee7.jpa.webclient;

import lombok.Data;

@Data
public class AuthResponse {
	String access_token;
	String refresh_token;
}
