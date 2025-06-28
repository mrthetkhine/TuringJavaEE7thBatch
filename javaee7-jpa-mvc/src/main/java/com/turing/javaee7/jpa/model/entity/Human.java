package com.turing.javaee7.jpa.model.entity;

import java.util.Date;

import org.hibernate.annotations.Formula;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class Human extends BaseEntity{

	//Name name;
	
	@Column
	String firstName;
	
	@Column
	String lastName;
	
	//@Transient
	@Formula(value = "CONCAT(first_name,\" \",last_name)")
	String fullName;
	
		
	@Column
	Date birthday;
	
	@Column
	@Enumerated(EnumType.ORDINAL)
	Gender gender;
	
	
	
	@Formula(value = "TIMESTAMPDIFF(YEAR,birthday,CURDATE())")
	Integer age;


	/*
	@Override
	public String toString() {
		return "Human [name=" + name + ", birthday=" + birthday + ", gender=" + gender + ", age=" + age + "]";
	}*/

	
	@Override
	public String toString() {
		return "Human [firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday + ", gender="
				+ gender + "]";
	}
	
	
	
	
}
