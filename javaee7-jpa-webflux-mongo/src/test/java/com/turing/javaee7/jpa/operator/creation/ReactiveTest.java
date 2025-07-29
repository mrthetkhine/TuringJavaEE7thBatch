package com.turing.javaee7.jpa.operator.creation;


import java.time.Duration;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
public class ReactiveTest {
	//@Test
	public void testRange()
	{
		Flux<Long> rangeOfIntegers = Flux.range(1, 10)
				.interval(Duration.ofMillis(500));
		
		log.info("Started");
		rangeOfIntegers.subscribe(data->{
			log.info("Subscriber 1=> "+data);
		});
		rangeOfIntegers.subscribe(data->{
			log.info("Subscriber 2=> " +data);
		});
		log.info("End");
		
		StepVerifier.create(rangeOfIntegers)
				.expectNextCount(10)
				.verifyComplete();
				
	}
	//@Test
	public void testZip()
	{
		Flux<Long> list1 = Flux.range(1, 10)
				.interval(Duration.ofMillis(500));
		Flux<Long> list2 = Flux.range(2, 10)
				.interval(Duration.ofMillis(300));
		Flux.zip(list1,list2)
			.subscribe(data->{
				log.info("Data t1 "+data.getT1()+ " t2 "+ data.getT2());
			});
		StepVerifier.create(list1)
		.expectNextCount(10)
		.verifyComplete();
	}
	//@Test
	public void testJust()
	{
		Flux<String> letters = Flux.just("A", "B", "C");
		letters.subscribe(data->{
			log.info("Data "+data);
		});
	    StepVerifier.create(letters).expectNext("A", "B", "C").verifyComplete();
	    
	    
	    long now = System.currentTimeMillis();
	    Mono<Date> greetingMono = Mono.just(new Date(now));
	    greetingMono.subscribe(data->{
	    	log.info("Greeting date "+data);
	    });
	    Mono.empty()
	    	.subscribe(data->{
	    		log.info("Empty subscribe");
	    	});
	    StepVerifier.create(greetingMono)
	    			.expectNext(new Date(now))
	    			.verifyComplete();
	    
	}
	@Test
	public void testFromArray()
	{
		Flux<Integer> fromArray = Flux.fromArray(new Integer[] { 1, 2, 3 });
		
		fromArray.subscribe(data->{
			log.info("Data "+data);
		});
	    StepVerifier.create(fromArray)
	    			.expectNext(1, 2, 3)
	    			.verifyComplete();
	    AtomicInteger integer = new AtomicInteger();
	    Supplier<Integer> supplier = integer::incrementAndGet;
	    Flux<Integer> integerFlux = Flux.fromStream(Stream.generate(supplier));
	    integerFlux.take(3)
	    			.subscribe(data->{
	    				log.info("Data ==> "+data);
	    			});
	    StepVerifier.create(integerFlux.take(3))
	    			.expectNext(1)
	    			.expectNext(2)
	    			.expectNext(3)
	    			.expectComplete();
	}
}
