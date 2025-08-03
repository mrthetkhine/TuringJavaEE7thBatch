package com.turing.javaee7.jpa.operator.creation;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;

@Slf4j
public class CombineTest {
	//@Test
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
	
	//@Test
	public void testMerge()
	{
		Flux<Integer> list1 = Flux.range(1,10)
									.delayElements(Duration.ofMillis(300));
		Flux<Integer> list2 = Flux.range(20,10)
				.delayElements(Duration.ofMillis(100));
		Flux<Integer> result = Flux.merge(list1,list2);
			result.subscribe(data->{
				log.info("Data "+data);
			});
		StepVerifier.create(result).expectNextCount(20).verifyComplete();	
	}
	//@Test
	public void testZip()
	{
		Flux<Integer> list1 = Flux.range(1,4)
									.delayElements(Duration.ofMillis(300));
		Flux<String> list2 = Flux.just("One","Two","Three")
				.delayElements(Duration.ofMillis(100));
		Flux<Tuple2<Integer, String>> result = Flux.zip(list1, list2);
			result.subscribe(data->{
				log.info("Data "+data.getT1()+" t2 "+data.getT2());
			});
		StepVerifier.create(result).expectNextCount(3).verifyComplete();	
	}
	//@Test
	public void testAnd()
	{
		
		Mono<Integer> list1 = Mono.just(100)
						.delayElement(Duration.ofMillis(1000))
						.doOnNext(data->{
							log.info("List 1 emit");
						});
		Mono<Integer> list2 =  Mono.just(200)
						.delayElement(Duration.ofMillis(300))
						.doOnNext(data->{
							log.info("List 2 emit");
						});
		/*
		list1.subscribe(data->{
			log.info("list 1 emitted");
		});
		list2.subscribe(data->{
			log.info("list 2 emitted");
		});
		*/
		Mono<Void> result = list1.and(list2);
		
		result
			.doOnTerminate(()->{
				log.info("Terminated");
			})
			.subscribe(data->{
						log.info("Done "+data);
					});
		//StepVerifier.create(list1).expectNextCount(1).verifyComplete();
		//StepVerifier.create(list1).expectNextCount(1).verifyComplete();
		
		StepVerifier.withVirtualTime(() -> Mono.delay(Duration.ofSeconds(5)))
        .expectSubscription()
        .thenAwait(Duration.ofSeconds(2)) // Advance virtual time
        .expectNext(0L)
        .verifyComplete();
        
	}	
	@Test
	public void testRepeat()
	{
		Flux<Integer> list1 = Flux.just(1)
									.delayElements(Duration.ofMillis(300))
									.repeat(3);
		list1.subscribe(data->{
			log.info("Data "+data);
		});
		StepVerifier.create(list1).expectNextCount(4).verifyComplete();	
	}
}
