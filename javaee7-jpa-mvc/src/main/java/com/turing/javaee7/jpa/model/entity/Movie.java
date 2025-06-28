package com.turing.javaee7.jpa.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

	@OneToOne(optional=false,
				mappedBy = "movie",
				cascade = CascadeType.ALL,
				fetch=FetchType.LAZY)
	MovieDetails movieDetails;
	
	/*
	@Override
	public String toString() {
		return "Movie [title=" + title + ", year=" + year + ", genre=" + genre + "]";
	}*/

	
}
