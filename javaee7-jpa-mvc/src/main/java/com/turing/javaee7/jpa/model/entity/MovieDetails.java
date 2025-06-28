package com.turing.javaee7.jpa.model.entity;

import java.util.Date;



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
public class MovieDetails extends BaseEntity {

	@Column
	String details;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "movie_id")
	private Movie movie;
}
