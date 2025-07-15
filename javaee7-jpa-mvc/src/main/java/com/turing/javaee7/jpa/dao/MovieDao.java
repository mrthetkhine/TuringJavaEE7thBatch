package com.turing.javaee7.jpa.dao;

import java.util.List;

import com.querydsl.core.Tuple;
import com.turing.javaee7.jpa.dto.CountAndGenere;
import com.turing.javaee7.jpa.model.entity.Movie;

public interface MovieDao {
	List<Movie> finByYear(long year);
	List<Movie> finByYearAndGenre(Long year,String genre);
	Movie getFirstMovieByGenre(String genre);
	List<Movie> findMovieWithActor(String fullName);
	List<Movie> findMovieOrderByYear();
	List<CountAndGenere> findMovieGroupByGenre();
	List<Tuple> getAllMovieWithIdName();
	List<Movie> findMovieWithGenreSubquery(String genre);
	List<Movie> findMoviesWithTitle(List<String> titles);
}
