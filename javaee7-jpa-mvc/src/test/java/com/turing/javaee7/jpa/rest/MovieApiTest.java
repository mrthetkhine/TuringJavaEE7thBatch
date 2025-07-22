package com.turing.javaee7.jpa.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.turing.javaee7.jpa.controller.rest.api.impl.MovieApiController;
import com.turing.javaee7.jpa.service.MoneyTransferServiceTest;
import com.turing.javaee7.jpa.service.MovieService;
import  com.turing.javaee7.jpa.dto.*;
import lombok.extern.slf4j.Slf4j;


@Slf4j

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@WebMvcTest(MovieApiController.class)
@AutoConfigureMockMvc
public class MovieApiTest {
	/*
	@Autowired
	private MovieApiController controller;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	*/
	@Autowired
	private MockMvc mockMvc;
	
	@MockitoBean
	MovieService movieService;
	
	@Test
	void getAllMovieShouldReturnMovies() throws Exception {
		List<MovieDto> dtos = new ArrayList<MovieDto>();
		
		MovieDto movie1 = new MovieDto();
		movie1.setId(1L);
		movie1.setGenre("Drama");
		movie1.setTitle("Title 1");
		movie1.setYear(2000L);
		MovieDetailsDto details1 = new MovieDetailsDto();
		details1.setDetails("Title 1 details ");
		movie1.setMovieDetails(details1);
		
		dtos.add(movie1);
		
		MovieDto movie2 = new MovieDto();
		movie2.setId(1L);
		movie2.setGenre("Drama");
		movie2.setTitle("Title 1");
		movie2.setYear(2000L);
		MovieDetailsDto details2 = new MovieDetailsDto();
		details2.setDetails("Title 2 details ");
		movie2.setMovieDetails(details2);
		
		dtos.add(movie2);
		
		when(movieService.getAllMovies()).thenReturn(dtos);
	
		this.mockMvc.perform(get("/api/movies"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().string(containsString("Title 1")));
				
	}
}
