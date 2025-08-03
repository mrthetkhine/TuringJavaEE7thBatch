package com.turing.javaee7.jpa.webclient;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;

@Slf4j
public class ApiTest {
	WebClient webClient = WebClient.create("https://jsonplaceholder.typicode.com/");
	
	Mono<String> getTodo(int id)
	{
		return webClient.get()
				  .uri("/todos/"+id)
				  .retrieve()
				  .bodyToMono(String.class);
	}
	Mono<String> getUser(int id)
	{
		return webClient.get()
				  .uri("/users/"+id)
				  .retrieve()
				  .bodyToMono(String.class);
	}
	@Test
	public void testApiCall()
	{
		
		Mono<String> todoResult = getTodo(1);
		Mono<String> userResult = getUser(1);
		/*
		double start = System.currentTimeMillis();
		todoResult
			.doOnError(err->{
				log.info("Error "+err);
			})
			.subscribe(json->{
			  log.info("Got here");
			  userResult.subscribe(userJson->{
				double end = System.currentTimeMillis();
				double time = end-start;
				log.info("Time " + time);
			  	log.info("todo "+json);
				log.info("user json "+userJson);
			});
		  });
		
		*/
		
		double start = System.currentTimeMillis();
		Mono<Tuple2<String,String>> result= Mono.zip(todoResult, userResult);
		result
		.doOnNext(data->{
			log.info("Data "+data.getT1()+" t2 "+data.getT2());
		})
		.subscribe(tuple->{
			double end = System.currentTimeMillis();
			double time = end-start;
			log.info("Time " + time);
			log.info("Todo "+ tuple.getT1()+" User "+tuple.getT2());
		},(err)->{
			log.info("Error ",err);
		});
		log.info("Done");
		StepVerifier.create(todoResult).expectNextCount(1).verifyComplete();
		StepVerifier.create(userResult).expectNextCount(1).verifyComplete();
	}
					
}
