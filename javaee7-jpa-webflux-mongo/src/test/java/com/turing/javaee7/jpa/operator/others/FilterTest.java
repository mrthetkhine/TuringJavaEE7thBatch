package com.turing.javaee7.jpa.operator.others;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@Slf4j
public class FilterTest {
	//@Test
	public void testFilter()
	{
		Flux<Integer> result = Flux.just(1,2,3,4);
		Flux<Integer> evenList = result.filter(i->i%2==0);
		
		evenList.subscribe(even->{
			log.info("Even "+even);
		});
		StepVerifier.create(evenList).expectNextCount(2).verifyComplete();
	}
	@Test
	public void testFilterOfType()
	{
		Flux<Object> result = Flux.just(1,2,"Apple","Orange");
		Flux<String> list = result.ofType(String.class);
		
		list.subscribe(str->{
			log.info("Even "+str);
		});
		StepVerifier.create(list).expectNextCount(2).verifyComplete();
	}
}
