package com.turing.javaee7.jpa.operator.creation;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
public class AggregateTest {
	//@Test
	public void testCount()
	{
		
        Flux<Integer> lst = Flux.range(1, 10)
        						.delayElements(Duration.ofMillis(100));
        lst
        	.doOnNext(item->{
        		log.info("Do on next"+item);
        	})
        	.filter(item->item %2==0)
        	.count()
        	.subscribe(total->{
        		log.info("Total even list "+total);
        		
        	});
        StepVerifier.create(lst).expectNextCount(10).verifyComplete();
	}
	//@Test
	public void testAll()
	{
		
        Flux<Integer> lst = Flux.range(-1, 10)
        						.delayElements(Duration.ofMillis(100));
        lst
        	.doOnNext(item->{
        		log.info("Do on next"+item);
        	})
        	.any(item->item>0)
        	.subscribe(total->{
        		log.info("All > 0 "+total);
        		
        	});
        StepVerifier.create(lst).expectNextCount(10).verifyComplete();
	}
	@Test
	public void testHasElement()
	{
		
        Flux<String> lst = Flux.just("apple","orange");
        lst
        	.doOnNext(item->{
        		log.info("Do on next"+item);
        	})
        	.hasElement("orange")
        	.subscribe(data->{
        		log.info("Has element"+data);
        		
        	});
       //StepVerifier.create(lst).expectNextCount(2).verifyComplete();
	}
}
