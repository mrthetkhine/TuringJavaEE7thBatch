package com.turing.javaee7.jpa.operator.transform;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@Slf4j
public class TransformTest {
	@Test
	public void testMap()
	{
		Flux<Integer> items = Flux.range(1, 10);
		items.subscribe(data->{
			log.info("Org stream "+data);
		});
		Flux<Integer> result = items.map(x->x*2);
			result.subscribe(data->{
				log.info("data "+data);
			});
		StepVerifier.create(result).expectNextCount(10).verifyComplete();
	}
}
