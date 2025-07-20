package com.turing.javaee7.jpa.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MovieDto {
	Long id;
	
	@NotBlank(message = "{required.movie.title}")
	@Size(min = 3, max = 100, message = "{size.movie.title}")
	String title;
	
	@NotNull(message = "{required.movie.year}")
	Long year;
	
	@NotBlank(message = "{required.movie.genre}")
	@Size(min = 3, max = 100, message = "{size.movie.genre}")
	String genre;
	
	@NotNull(message = "{required.movie.movieDetails}")
	MovieDetailsDto movieDetails;
	
	
	
}
