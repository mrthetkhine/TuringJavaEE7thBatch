package com.turing.javaee7.jpa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.turing.javaee7.jpa.dto.TitleAndGenre;
import com.turing.javaee7.jpa.dto.TitleAndGenreC;
import com.turing.javaee7.jpa.dto.TitleGenre;
import com.turing.javaee7.jpa.model.entity.Book;
import com.turing.javaee7.jpa.model.entity.Movie;

import jakarta.transaction.Transactional;

@Repository
public interface MovieDao  extends JpaRepository<Movie,Long>,JpaSpecificationExecutor<Movie>{

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
	
	@Query("SELECT m FROM Movie m")
	List<Movie> getAllMovie();
	
	@Query("SELECT m FROM Movie m WHERE m.genre=?1 ")
	List<Movie> findAllMovieWithGenre(String genre);
	
	@Query("SELECT COUNT(m) FROM Movie m WHERE m.genre=?1 ")
	Long findMovieCountWithGenre(String genre);
	
	@Query("SELECT m.title AS title ,m.genre As genre FROM Movie m")
	List<TitleAndGenre> findAllMovieWithTitleAndGenre();
	
	@Query("SELECT m.title AS title ,m.genre As genre FROM Movie m")
	List<TitleGenre> findAllMovieWithTitleAndGenreWithClassProjection();
	
	@Query("select m fROM Movie m WHERE m.year > ?1 ")
	List<Movie> findMovieWithYearGt(Long year);
	
	@Query("SELECT new com.turing.javaee7.jpa.dto.TitleAndGenreC(m.title, m.genre) FROM Movie m")
	//@Query("SELECT m.title AS title ,m.genre As genre FROM Movie m")
	List<TitleAndGenreC> findAllMovieWithTitleAndGenreC();
	
	@Query("SELECT m FROM Movie m JOIN m.actors a WHERE a.fullName =?1 ")
	List<Movie> findAllMovieWithActorIn(String fullName);
	
	@Query("SELECT m FROM Movie m LEFT JOIN m.actors a ON a.id=?1")
	List<Movie> findAllMovieWithActorInLeftJoinWithActorIn(Long id);
	
	@Query("SELECT m FROM Movie m ORDER BY m.year DESC")
	List<Movie> findAllMovieOrderByYear();
	
	@Transactional
	@Modifying
	@Query("UPDATE Movie m SET m.genre=?2 WHERE m.id=?1")
	int updateGnereByMovieId(Long id,String genre);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Movie m WHERE m.id=?1")
	int deleteMovieById(Long id);
	
	@Modifying
	@Transactional
	@Query("INSERT Movie(title) VALUES (:title1),(:title2)")
	int insertTwoMovie(String title1, String title2);
}
