package com.turing.javaee7.jpa.operator.creation;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@Slf4j
public class CombineTest {
	@Test
	public void testCombine()
	{
		Flux<Integer> list1 = Flux.range(1,10)
									.delayElements(Duration.ofMillis(300));
		Flux<Integer> list2 = Flux.range(20,10)
				.delayElements(Duration.ofMillis(100));
		Flux<Integer> result = Flux.concat(list1,list2);
			result.subscribe(data->{
				log.info("Data "+data);
			});
		StepVerifier.create(result).expectNextCount(20).verifyComplete();	
	}
}
