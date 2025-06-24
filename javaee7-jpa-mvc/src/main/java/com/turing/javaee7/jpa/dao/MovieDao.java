package com.turing.javaee7.jpa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turing.javaee7.jpa.model.entity.Book;
import com.turing.javaee7.jpa.model.entity.Movie;

@Repository
public interface MovieDao  extends JpaRepository<Movie,Long>{

	
}
