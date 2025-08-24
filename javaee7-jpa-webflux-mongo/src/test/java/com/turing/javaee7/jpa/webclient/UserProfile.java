package com.turing.javaee7.jpa.webclient;

import lombok.Data;

@Data
public class UserProfile {
	 String id;
	 String email;
	 String password;
	 String name;  
	 String role; 
	 String avatar;
}
