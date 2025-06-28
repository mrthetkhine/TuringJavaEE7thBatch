package com.turing.javaee7.jpa.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.turing.javaee7.jpa.model.entity.Actor;
import com.turing.javaee7.jpa.model.entity.Gender;
import com.turing.javaee7.jpa.model.entity.Movie;
import com.turing.javaee7.jpa.model.entity.Name;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class ActorDaoTest {
	@Autowired
	ActorDao actorDao;
	
	@Test
	public void testInsertActor()
	{
		Actor actor = new Actor();
		//Name name = new Name();
		
		actor.setFirstName("FirstName");
		actor.setLastName("LastName");
		//actor.setName(name);
		actor.setGender(Gender.Female);
		
		Date birthDate = new GregorianCalendar(1974, 10, 11).getTime();
		actor.setBirthday(	birthDate);
		
		this.actorDao.save(actor);
		assertNotNull(actor.getId());
		
		log.info("Actor "+actor);
	}
	//@Test
	public void updateBirthdate()
	{
		Optional<Actor> actorResult = this.actorDao.findById(2L);
		Actor actor = actorResult.get();
		Date birthDate = new GregorianCalendar(1975, 10, 11).getTime();
		actor.setBirthday(	birthDate);
		
		this.actorDao.save(actor);
	}
	/*
	@Test
	public void testFormulaFullName()
	{
		Optional<Actor> actorResult = this.actorDao.findById(2L);
		
		Actor actor = actorResult.get();
		
		log.info("Fullname "+actor.getFullName());
		log.info("Age " + actor.getAge());
		
		assertEquals("Kate Winslet",actor.getFullName());
		assertEquals(49,actor.getAge());
	}*/
}
