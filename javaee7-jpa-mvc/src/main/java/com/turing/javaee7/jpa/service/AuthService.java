package com.turing.javaee7.jpa.service;

import com.turing.javaee7.jpa.dto.UserDto;

public interface AuthService {
	public void register(UserDto userDto)throws Exception ;
	public String login(UserDto userDto); 
}
