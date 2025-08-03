package com.turing.javaee7.jpa.operator.others;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@Slf4j
public class PeekingTest {
	@Test
	public void testPeek()
	{
		Flux<Integer> result = Flux.range(1, 10)
									.delayElements(Duration.ofMillis(100));
		try
		{
			result		
			.map(item->{
				if(item==6)
				{
					throw new RuntimeException("Stop at 6");
				}
				else
				{
					return item;
				}
			})
			.doOnNext(data->{
				log.info("doOnNext "+data);
			})
			.doOnError(err->{
				log.info("doOnError "+err.getMessage());
			})
			.doOnComplete(()->{
				log.info("doOnComplete ");
			})
			.doOnTerminate(()->{
				log.info("doOnTerminate ");
			})
			.doFinally((onFinally)->{
				log.info("doFinally ");
			})
			.log()
			.subscribe(item->{
				log.info("Subscribe "+item);
			});
		}
		catch(Exception e)
		{
			log.info("Error--> "+e.getMessage());
		}
		log.info("Done ");
		
		StepVerifier.create(result).expectNextCount(10).verifyComplete();
	}
}
