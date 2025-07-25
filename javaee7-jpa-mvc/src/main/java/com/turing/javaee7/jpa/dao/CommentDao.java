package com.turing.javaee7.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.turing.javaee7.jpa.dto.MovieIdCommentCount;
import com.turing.javaee7.jpa.model.entity.Comment;
import com.turing.javaee7.jpa.model.entity.Movie;

@Repository
public interface CommentDao  extends JpaRepository<Comment,Long>,JpaSpecificationExecutor<Comment>{
	@Query("SELECT cm.movie.id,COUNT(*) FROM Comment cm GROUP BY cm.movie")
	List<MovieIdCommentCount> getNoOfCommentByMovieId();
	
	@Query("SELECT cm.movie.id,COUNT(*) FROM Comment cm GROUP BY cm.movie HAVING count(*)>=?1")
	List<MovieIdCommentCount> getMovieWhichCommentIsGt(int count);
}
