package com.turing.javaee7.jpa.dao.querymethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import com.turing.javaee7.jpa.dao.MovieDao;
import com.turing.javaee7.jpa.dao.MovieDetailsDao;
import com.turing.javaee7.jpa.model.entity.Movie;
import com.turing.javaee7.jpa.model.entity.MovieDetails;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@Rollback(false)
public class MoviePagniationTest {
	@Autowired
	MovieDao movieDao;
	
	
	
	//@Test
	public void testPagination()
	{
		Pageable page = PageRequest.of(1, 5);
		Page<Movie> movies = this.movieDao.findAll(page);
		movies.forEach(System.err::println);
	}
	@Test
	public void testPaginationWithSort()
	{
		Pageable page = PageRequest.of(0, 5,Sort.by("year").descending());
		Page<Movie> movies = this.movieDao.findAll(page);
		movies.forEach(System.err::println);
	}
	
}
