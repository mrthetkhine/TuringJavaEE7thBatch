package com.turing.javaee7.jpa.operator.creation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.test.StepVerifier;

@Slf4j
public class CreateAsyncTest {
	private final ExecutorService executorService = Executors.newFixedThreadPool(1);

	private void launch(FluxSink<Integer> integerFluxSink, int count) {

		this.executorService.submit(() -> {
			var integer = new AtomicInteger();

			while (integer.get() < count) {

				double random = Math.random();
				integerFluxSink.next(integer.incrementAndGet());
				this.sleep((long) (random * 1_000));
			}
			integerFluxSink.complete();
		});
	}

	private void sleep(long s) {
		try {
			Thread.sleep(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//@Test
	public void testAsync() {
		Flux<Integer> integers = Flux.create(emitter -> this.launch(emitter, 5));
		integers.subscribe(data->{
			log.info("Data" +data);
		});
		StepVerifier.create(integers).expectNextCount(5).verifyComplete();
	}
	@Test
	public void testCreate()
	{
		Flux<Integer> integers = Flux.create(emitter->{
			emitter.next(1);
			emitter.next(10);
			emitter.next(20);
			emitter.complete();
			
		});
		integers.subscribe(data->{
			log.info("Data" +data);
		});
		StepVerifier.create(integers).expectNextCount(3).verifyComplete();
	}

}
