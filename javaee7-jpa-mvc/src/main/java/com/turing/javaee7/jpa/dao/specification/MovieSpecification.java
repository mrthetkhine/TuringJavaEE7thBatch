package com.turing.javaee7.jpa.dao.specification;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;

import com.turing.javaee7.jpa.model.entity.Actor;
import com.turing.javaee7.jpa.model.entity.Movie;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.CriteriaBuilder.In;
public class MovieSpecification {
	//Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder
	 public static Specification<Movie> getAllMovieInYear(long year) {
		    return (root, query, builder) -> {
		      return builder.equal(root.get("year"), year);
		    };
	}
	 public static Specification<Movie> getMovieByYear(Long i) {
			return new Specification<Movie>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Movie> root,
					CriteriaQuery<?> query, 
					CriteriaBuilder cb) {
				return cb.equal(root.<Long>get("year"), i);
			}
			
		};  
	 }
	 public static Specification<Movie> getAllMovieByTitle(String title) {
		    return (root, query, builder) -> {
		      return builder.equal(root.get("title"), title);
		    };
	}
	 public static Specification<Movie> getMovieByYearGt(Long i) {
			return new Specification<Movie>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Movie> root,
					CriteriaQuery<?> query, 
					CriteriaBuilder cb) {
				return cb.gt(root.<Long>get("year"), i);
				
			}
			
		};  
	 }
	 public static Specification<Movie> getMovieByTitleOrYear(String title, Long year) {
		    return (root, query, cb) -> {
		    	ArrayList<Predicate> predicates = new ArrayList<Predicate>();
		    	
		    	if(title !=null)
		    	{
		    		predicates.add(cb.equal(root.get("title"),title));
		    	}
		    	if(year != null)
		    	{
		    		predicates.add(cb.equal(root.get("year"),year));
		    	}
		    	if(predicates.size()!=0)
		    	{
		    		Predicate or = cb.or(predicates.toArray(new Predicate[] {}));
					
					query.where(or);
					return or;
		    	}
		    	else
		    	{
		    		return query.getRestriction();
		    	}
		    	
		    };
	}
	 public static Specification<Movie> getMovieWhereActorIn(String actor) {
		    return (root, query, cb) -> {
		    Join<Movie, Actor> actors = root.join("actors");
		    
		    return cb.like(actors.get("fullName"), "%"+actor+"%");
		  };
	}
	 public static Specification<Movie> getMovieOrderByYear() {
		    return (root, query, cb) -> {
		  
		    	query.orderBy(cb.asc(root.get("year")));
			    return query.getRestriction();
		  };
	}
	 public static Specification<Movie> getMovieInGenere(List<String> genres) {
		    return (root, query, builder) -> {
		    	
		    In<String> inClause = builder.in(root.get("genre"));	
		    for (String genre : genres) {
		        inClause.value(genre);
		    }
		    return inClause;
		  };
	}
	
}
