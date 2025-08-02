package com.turing.javaee7.jpa.operator.transform;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
public class TransformTest {
	//@Test
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
	//@Test
	public void testFilter()
	{
		Flux<Integer> items = Flux.just(1,2,3,4,5,6);
		Flux<Integer> evenList = items.filter(x->x%2==0);
		
		evenList.subscribe(data->{
				log.info("data "+data);
			});
	
	}
	//@Test
	public void testReduce()
	{
		Flux<Integer> items = Flux.just(1,2,3,4,5,6);
		Mono<Integer> total = items.reduce((a,b)->a+b);
		
		total.subscribe(data->{
				log.info("Sum "+data);
			});
	
	}
	//@Test
	public void testDoOnNext()
	{
		Flux<Integer> items = Flux.just(1,2,3,4,5,6);
		items
			.map(item->item*2)
			.doOnNext(item->{
			log.info("Do On Next "+item);
		})
		.subscribe();
	
	}
	static Mono<Integer> wrap(int i)
	{
		return Mono.just(i);
	}
	//@Test
	public void testFlatMap()
	{
		Flux<Integer> items = Flux.just(1,2,3,4,5,6);
		items
			.flatMap(item->wrap(item))
			.doOnNext(item->{
				log.info("Do On Next "+item);
			})
			.subscribe();
	
	}
	//@Test
	public void testSwitchMap()
	{
		Flux<String> source = Flux //
                .just("re", "rea", "reac", "react", "reactive") //
                .delayElements(Duration.ofMillis(100))//
                
                .doOnNext(item->{
                	log.info("Do On Next "+item);
                })
                .switchMap(this::lookup)
                .doOnNext(item->{
                	log.info("Item "+item);
                });
        StepVerifier.create(source).expectNext("reactive -> reactive").verifyComplete();
	
	}
	private Flux<String> lookup(String word) {
        return Flux.just(word + " -> reactive")//
                .delayElements(Duration.ofMillis(500));
	}
	static Flux<Integer> wrap2(int i)
	{
		return Flux.just(i,i*2);
	}
	static Mono<Integer> wrapMono(int i)
	{
		return Mono.just(i*2);
	}
	//@Test
	public void testFlatMapMany()
	{
		Flux<Integer> items = Flux.just(1,2,3,4,5,6);
		Mono<Integer> mono=Mono.just(10);
		mono.flatMapMany(item->wrap2(item))//Mono->Flux->Flat
			.subscribe(data->{
				log.info("Data "+data);
			});
	}
	//@Test
	public void testStartWith()
	{
		Flux<Integer> items = Flux.just(1,2,3,4,5,6);
		items
		.startWith(10,20,30)
		.concatWithValues(40,50)
		.subscribe(item->{
			log.info("Item "+item);
		});
	}
	@Test
	public void testCollectList()
	{
		Flux<Integer> items = Flux.just(1,2,3,4,5,6);
		Mono<List<Integer>> result = items.collectList();
		result.subscribe(list->{
			log.info("list size" +list.size());
			list.forEach(item->log.info("Item "+item));
		});
	}
}
