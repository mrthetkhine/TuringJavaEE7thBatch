package com.turing.javaee7.jpa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.JPQLTemplates;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.turing.javaee7.jpa.dao.MovieDao;
import com.turing.javaee7.jpa.model.entity.Movie;
import com.turing.javaee7.jpa.model.entity.*;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MovieDaoImpl implements MovieDao {

	 @PersistenceContext
	 private EntityManager em;

	 private JPAQueryFactory queryFactory;
	 
	
	 @PostConstruct
	 public void init()
	 {
		 this.queryFactory = new JPAQueryFactory(JPQLTemplates.DEFAULT, em);
	 }
	 
	@Override
	public List<Movie> finByYear(long year) {
		 final JPAQuery<Movie> query = new JPAQuery<>(em);
		 final QMovie movie = QMovie.movie;
		
		 return query
				 	.from(movie)
				 	.where(movie.year.goe(year))
				 	.fetch();
	}

}
