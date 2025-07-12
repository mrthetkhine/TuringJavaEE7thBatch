package com.turing.javaee7.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turing.javaee7.jpa.dao.MovieDao;
import com.turing.javaee7.jpa.model.entity.Movie;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api/movies")
public class HomeController {
	
	@Autowired
	MovieDao movieDao;
	
	@GetMapping
	@Transactional
	List<Movie> getAllBooks()
	{
		return this.movieDao.findAll();
	}
	
	@GetMapping("/{movieId}")
	Optional<Movie> getMovieById(@PathVariable Long movieId)
	{
		log.info("getMovieById==> ");
		
		return this.movieDao.findById(movieId);
	}
}
