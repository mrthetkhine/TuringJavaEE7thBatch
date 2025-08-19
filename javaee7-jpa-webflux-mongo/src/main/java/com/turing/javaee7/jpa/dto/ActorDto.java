package com.turing.javaee7.jpa.dto;

import java.util.Date;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorDto {
	
    String id;
	
    @NotBlank(message="Actor first name must not be blank")
    @Size(max = 140)
	String firstName;
    
    @NotBlank(message="Actor last name must not be blank")
    @Size(max = 140)
	String lastName;
	
    @NotBlank(message="Actor gender must not be blank")
    @Size(max = 10)
	String gender;
}
