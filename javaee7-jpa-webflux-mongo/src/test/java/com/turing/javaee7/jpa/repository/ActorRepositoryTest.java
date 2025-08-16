package com.turing.javaee7.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.turing.javaee7.jpa.DelayUtil;
import com.turing.javaee7.jpa.model.Actor;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
@Rollback(false)
@SpringBootTest
public class ActorRepositoryTest {
	
	@Autowired
	ActorRepository actorRepository;
	
	@Test
	public void testSaveActor()
	{
		Actor actor = new Actor();
		
		actor.setFirstName("Keanu");
		actor.setLastName("Reeves");
		actor.setGender("Male");
		
		log.info("save actor");
		
		Mono<Actor> actorResult = this.actorRepository.save(actor);
		actorResult.subscribe(act->{
								log.info("Actor Id "+ act.getId());
							});
		//StepVerifier.create(actorResult).verifyComplete();
		DelayUtil.delay(2000);
	}
}
