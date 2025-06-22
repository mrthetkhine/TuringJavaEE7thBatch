package com.turing.javaee7.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.turing.javaee7.jpa.model.entity.Book;

@Repository
public interface BookDao extends JpaRepository<Book,Long>{

}
