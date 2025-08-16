package com.turing.javaee7.jpa.operator.transform;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import com.turing.javaee7.jpa.DelayUtil;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
public class ControlFlowTest {

	Mono<String> getMovieNameById(int id)
	{
		if(id==0)
		{
			return Mono.empty();
		}
		else
		{
			return Mono.just("Movie "+id);
		}
	}
	
	//@Test
	public void testDefaultIfEmpty()
	{
		this.getMovieNameById(0)
			//.defaultIfEmpty("Movie not found")
			.switchIfEmpty(Mono.just("Movie not found"))
			.subscribe(data->{
				log.info("Movie name "+data);
			});
	}
	@Test
	public void testThen()
	{
		Flux<Integer> list1 = Flux.just(100)
								.delayElements(Duration.ofMillis(500))
								.doOnNext(data->{
									log.info("Data emit "+data);
								});
		Flux<Integer> list2 = Flux.just(300)
				
				.delayElements(Duration.ofMillis(1500))
				.doOnNext(data->{
					log.info("Data emit list2 "+data);
				});
		Flux<Integer> result = list2.thenMany(list1)
			.doOnTerminate(()->{
				log.info("Done");
			});
		
		result.subscribe();
		DelayUtil.delay(3000);
		//StepVerifier.create(list1).expectNextCount(1).verifyComplete();
		//StepVerifier.create(result).expectNextCount(1).verifyComplete();
		
	}
}
