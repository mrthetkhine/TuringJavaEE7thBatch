package com.turing.javaee7.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turing.javaee7.jpa.model.entity.Actor;


@Repository
public interface ActorDao  extends JpaRepository<Actor,Long>{

}
