package com.turing.javaee7.jpa.dto;

import java.util.Date;

import org.hibernate.annotations.Formula;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class HumanDto {

	//Name name;
	Long id;
	
	@NotBlank(message = "{required.human.firstName}")
	@Size(min = 3, max = 100, message = "{size.human.firstName}")
	String firstName;
	
	@NotBlank(message = "{required.human.firstName}")
	@Size(min = 3, max = 100, message = "{size.human.firstName}")
	String lastName;

	
	@NotNull(message = "{required.human.birthday}")
	Date birthday;
	
	@NotBlank(message = "{required.human.gender}")
	String gender;
	

	
}
