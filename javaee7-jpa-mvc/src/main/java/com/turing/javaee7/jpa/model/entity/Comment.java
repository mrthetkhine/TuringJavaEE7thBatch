package com.turing.javaee7.jpa.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Comment extends BaseEntity{

	@Column
	String comment;
	
	@ManyToOne(
			fetch=FetchType.LAZY,
			cascade= CascadeType.ALL)
	@JoinColumn(name = "movie_id")
	private Movie movie;
}
