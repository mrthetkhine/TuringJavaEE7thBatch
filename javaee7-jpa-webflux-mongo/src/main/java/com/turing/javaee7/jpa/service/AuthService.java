package com.turing.javaee7.jpa.service;


import com.turing.javaee7.jpa.dto.TokenResponse;
import com.turing.javaee7.jpa.model.User;

import reactor.core.publisher.Mono;

public interface AuthService {
	Mono<TokenResponse> register(User user);
	Mono<TokenResponse> login(User user);

}
