package com.turing.javaee7.jpa.security;

import org.springframework.security.core.AuthenticationException;

class JwtAuthenticationException extends AuthenticationException {
    JwtAuthenticationException(String msg) {
        super(msg);
    }
}