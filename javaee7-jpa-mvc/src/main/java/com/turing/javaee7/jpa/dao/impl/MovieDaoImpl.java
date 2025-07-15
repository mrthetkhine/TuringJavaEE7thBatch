package com.turing.javaee7.jpa.dao.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLTemplates;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.turing.javaee7.jpa.dao.MovieDao;
import com.turing.javaee7.jpa.dto.CountAndGenere;
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

	@Override
	public Movie getFirstMovieByGenre(String genre) {
		final JPAQuery<Movie> query = new JPAQuery<>(em);
		final QMovie movie = QMovie.movie;
		return query
					.from(movie)
					.where(movie.genre.eq(genre))
					.fetchFirst();
	}

	@Override
	public List<Movie> finByYearAndGenre(Long year, String genre) {
		final JPAQuery<Movie> query = new JPAQuery<>(em);
		final QMovie movie = QMovie.movie;
		List<Predicate> predicates = new ArrayList<>();
		if(year != null)
		{
			predicates.add(movie.year.eq(year));
		}
		if(genre !=null)
		{
			predicates.add(movie.genre.eq(genre));
		}
		Predicate[] predicate = predicates.toArray(new Predicate[] {});
		return query
					.from(movie)
					.where(predicate)		
					.fetch();
	}

	@Override
	public List<Movie> findMovieWithActor(String fullName) {
		final JPAQuery<Movie> query = new JPAQuery<>(em);
		final QMovie movie = QMovie.movie;
		final QActor actor  = QActor.actor;
		return query	
					.from(movie)
					.innerJoin(movie.actors,actor)
					.where(actor.fullName.contains(fullName))
					.fetch();
	}

	@Override
	public List<Movie> findMovieOrderByYear() {
		 final JPAQuery<Movie> query = new JPAQuery<>(em);
		 final QMovie movie = QMovie.movie;
		
		 return query
				 	.from(movie)
				 	.orderBy(movie.year.desc())
				 	.fetch();
	}

	@Override
	public List<CountAndGenere> findMovieGroupByGenre() {
		final JPAQuery<Movie> query = new JPAQuery<>(em);
		final QMovie movie = QMovie.movie;
		
		return query
					.select(Projections.constructor(CountAndGenere.class, movie.count(),movie.genre))
				 	.from(movie)
				 	.groupBy(movie.genre)
				 	.fetch();
	}

	@Override
	public List<Tuple> getAllMovieWithIdName() {
		final JPAQuery<Movie> query = new JPAQuery<>(em);
		final QMovie movie = QMovie.movie;
		
		return query
					.select(movie.id,movie.title)
				 	.from(movie)
				 	.fetch();
	}

	@Override
	public List<Movie> findMovieWithGenreSubquery(String genre) {
		final JPAQuery<Movie> query = new JPAQuery<>(em);
		final QMovie movie = QMovie.movie;
	
		return query 
				   .from(movie)
				   .where(movie.id.in(
						   JPAExpressions.select(movie.id)
						   				.from(movie)
						   				.where(movie.genre.eq(genre))
						   ))
				   .fetch();
	}

	@Override
	public List<Movie> findMoviesWithTitle(List<String> titles) {
		final JPAQuery<Movie> query = new JPAQuery<>(em);
		final QMovie movie = QMovie.movie;
		BooleanBuilder builder = new BooleanBuilder();
		for(String title : titles)
		{
			builder.or(movie.title.contains(title));
		}
		
		return query
				 	.from(movie)
				 	.where(builder)
				 	.fetch();
	}

}
