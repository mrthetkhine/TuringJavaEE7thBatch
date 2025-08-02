package com.turing.javaee7.jpa.operator.creation;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class ReactiveStream {
	@Test
	public void testReactiveStream()
	{
		//Flux<Integer> result = Flux.just(1,2,3,4);
		//Flux<Integer> result = Flux.empty();
		Flux<Integer> result = Flux.error(new RuntimeException("Error"));
		result.map(item->{
			if(item==3)
			{
				throw new RuntimeException("We got three");
				//return 3;
			}
			else
			{
				return item;
			}
		})
		.doOnNext(item->{
			log.info("Next "+item);
		})
		.doOnError(err->{
			log.info("Error==> "+err.getMessage());
		})
		.doOnComplete(()->{
			log.info("Completed");
		})
		.doFinally(consumer->{
			log.info("Do onFinally");
		})
		.subscribe();
	}
}
