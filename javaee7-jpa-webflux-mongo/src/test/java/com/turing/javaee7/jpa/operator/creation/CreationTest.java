package com.turing.javaee7.jpa.operator.creation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

import com.turing.javaee7.jpa.operator.transform.TransformTest;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
public class CreationTest {
	//@Test
	public void testCreate()
	{
		Flux<Integer> result = Flux.just(10);
		//StepVerifier.create(result).expectNext(10).verifyComplete();
		
		Optional<String> opt = Optional.ofNullable("hello");
		Mono<String> result2 = Mono.justOrEmpty(opt);
		//Mono<String> result2 = Mono.just(null);
		result2.map(x->x.toUpperCase())
			   .map(x->x+" hi")	
			   .subscribe(data->{
				  log.info("Data "+data);
			   },err->{
				   log.info("Error "+err);
			   }); 	
	}
	//@Test
	public void testFromArray()
	{
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		Flux<Integer> result = Flux.fromIterable(list);
		result.subscribe(item->{
			log.info("Item "+item);
		});
	}
	String getData()
	{
		log.info("get Data executed");
		 try {
             Thread.sleep(1000); // Simulate delay
         } catch (InterruptedException e) {
             Thread.currentThread().interrupt();
         }
         return "Some data";
	}
	//@Test
	public void testSupplier()
	{
		Supplier<String> dataSupplier = ()-> {
			return getData();
		};
        Mono<String> mono = Mono.fromSupplier(dataSupplier);
       
        log.info("Subscribing to Mono...");
        mono.subscribe(
            value -> log.info("Received: " + value),
            error -> log.info("Error: " + error),
            () -> log.info("Mono completed.")
        );
        mono.subscribe(
                value -> log.info("Received2: " + value),
                error -> log.info("Error2: " + error),
                () -> log.info("Mono completed2.")
            );
	}
	//@Test
	public void testFromCallable()
	{
		
        Mono<String> mono = Mono.fromCallable(()->{
        	return getData();
        });
       
        log.info("Subscribing to Mono...");
        mono.subscribe(
            value -> log.info("Received: " + value),
            error -> log.info("Error: " + error),
            () -> log.info("Mono completed.")
        );
        mono.subscribe(
                value -> log.info("Received2: " + value),
                error -> log.info("Error2: " + error),
                () -> log.info("Mono completed2.")
            );
	}
	@Test
	public void testDefer()
	{
		
        Mono<String> mono = Mono.defer(()->{
        	log.info("Before defer returned");
        	return Mono.just(getData());
        });
       
        log.info("Subscribing to Mono...");
        mono.subscribe(
            value -> log.info("Received: " + value),
            error -> log.info("Error: " + error),
            () -> log.info("Mono completed.")
        );
        mono.subscribe(
                value -> log.info("Received2: " + value),
                error -> log.info("Error2: " + error),
                () -> log.info("Mono completed2.")
            );
	}
}
