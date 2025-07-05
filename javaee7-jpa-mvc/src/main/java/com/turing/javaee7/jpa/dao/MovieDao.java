package com.turing.javaee7.jpa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.turing.javaee7.jpa.model.entity.Book;
import com.turing.javaee7.jpa.model.entity.Movie;

@Repository
public interface MovieDao  extends JpaRepository<Movie,Long>{

	List<Movie> findByTitleIgnoreCase(String title);
	List<Movie> findByYear(Long year);
	List<Movie> findByTitleContains(String title);
	List<Movie> findByTitleLike(String title);
	List<Movie> findFirst2ByGenre(String genre);
	
	List<Movie> findByYearGreaterThan(Long year);
	List<Movie> findByYearAndGenre(Long year, String genre);
	List<Movie> findByYearOrGenre(Long year, String genre);
	List<Movie> findByGenreOrderByYear(String genre);
	List<Movie> findByGenreOrderByYearDesc(String genre);
	List<Movie> findByGenreIn(List<String> genres);
	List<Movie> findDistinctMovieByGenre(String genre);
	long countByGenre(String genre);
	boolean existsMovieByGenre(String genre);
	
	long deleteByGenre(String genre);
	
	@Query("from Movie m where year=?1")
	List<Movie> findMovieByYear(Long year);
	
	@Query(value="SELECT * FROM Movie m WHERE year=?1",nativeQuery=true)
	List<Movie> findMovieByYearNative(Long year);
}
