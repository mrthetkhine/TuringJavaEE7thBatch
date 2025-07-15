package com.turing.javaee7.jpa.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.turing.javaee7.jpa.model.entity.Actor;
import com.turing.javaee7.jpa.model.entity.Comment;
import com.turing.javaee7.jpa.model.entity.MovieDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;

public class MovieDto {
	Long id;
	
	String title;
	
	Long year;
	
	String genre;
	
	
	
	
}
