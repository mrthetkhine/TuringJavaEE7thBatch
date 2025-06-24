package com.turing.javaee7.jpa.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Movie extends BaseEntity{

	@Column
	String title;
	
	@Column
	Long year;
	
	@Column
	String genre;

	@Override
	public String toString() {
		return "Movie [title=" + title + ", year=" + year + ", genre=" + genre + "]";
	}

	
}
