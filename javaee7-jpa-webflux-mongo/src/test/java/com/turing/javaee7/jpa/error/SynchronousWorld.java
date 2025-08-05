package com.turing.javaee7.jpa.error;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@Slf4j
public class SynchronousWorld {
	@Test
	public void testBlock()
	{
		Flux<Integer> list = Flux.just(1)
								.delayElements(Duration.ofMillis(1000));
		log.info("Blocked");
		Integer result = list.blockFirst();
		log.info("Result "+result);
		list.subscribe(data->{
			log.info("Data emitted =>"+data);
		});
		list.subscribe(data->{
			log.info("Data emitted 2=> "+data);
		});
		log.info("Done");
		StepVerifier.create(list).expectNextCount(1).verifyComplete();
	}
}
