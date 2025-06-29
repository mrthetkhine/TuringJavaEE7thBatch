package com.turing.javaee7.jpa.model.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
	
	@OneToMany(
			mappedBy="movie",
			cascade = CascadeType.ALL,
			fetch=FetchType.LAZY
			)
	List<Comment> comments = new ArrayList<>();
	

	@ManyToMany(
			fetch=FetchType.LAZY
			,cascade= {
					CascadeType.MERGE,
					CascadeType.PERSIST
			})
	@JoinTable(name="actor_in_movie",
			joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "actor_id") })
	private Set<Actor> actors = new HashSet<>();
	
	@ManyToMany(
			fetch=FetchType.LAZY,
			cascade= {
					CascadeType.MERGE,
					CascadeType.PERSIST
			}
			)
	@JoinTable(name="director_in_movie",
			joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "director_id") })
	private Set<Director> directors=new HashSet<>();
	
	@Override
	public String toString() {
		return "Movie [title=" + title + ", year=" + year + ", genre=" + genre + "]";
	}

	
}
