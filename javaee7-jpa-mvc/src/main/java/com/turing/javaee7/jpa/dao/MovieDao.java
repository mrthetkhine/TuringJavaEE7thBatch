package com.turing.javaee7.jpa.dao;

import java.util.List;

import com.turing.javaee7.jpa.model.entity.Movie;

public interface MovieDao {
	List<Movie> finByYear(long year);
}
