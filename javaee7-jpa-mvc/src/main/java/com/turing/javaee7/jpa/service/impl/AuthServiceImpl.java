package com.turing.javaee7.jpa.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.turing.javaee7.jpa.dao.UserRepository;
import com.turing.javaee7.jpa.dto.UserDto;
import com.turing.javaee7.jpa.model.entity.Role;
import com.turing.javaee7.jpa.model.entity.User;
import com.turing.javaee7.jpa.security.JwtService;
import com.turing.javaee7.jpa.security.SecurityUtil;
import com.turing.javaee7.jpa.service.AuthService;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
	SecurityUtil securityUtil;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
    AuthenticationManager authenticationManager;
	
	@Autowired
    JwtService jwtService;
  

	    
	@Transactional
	@Override
	public void register(UserDto userDto) throws Exception {
		User existingUser = this.userRepository.findByUsername(userDto.getUsername());
		if(existingUser!=null)
		{
			throw new Exception("user already existed");
		}
		else
		{
			User user = new User();
			user.setUsername(userDto.getUsername());
			user.setPassword(securityUtil.getHash(userDto.getPassword()));
			
			Role role1 = new Role();
			role1.setRole("ROLE_USER");
			user.getRoles().add(role1);
			
			this.userRepository.save(user);
			
			userDto.setPassword(user.getPassword());
			//return userDto;
		}
	}

	@Override
	public String login(UserDto userDto) {
		log.info("Login attempt "+userDto.getUsername());
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));
		log.info("Login ok "+userDto.getUsername());
        User u = userRepository.findByUsername(userDto.getUsername());
        return jwtService.generateToken(u);

	}
	
}
