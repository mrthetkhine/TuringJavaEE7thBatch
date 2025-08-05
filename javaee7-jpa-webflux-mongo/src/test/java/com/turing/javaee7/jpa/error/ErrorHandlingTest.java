package com.turing.javaee7.jpa.error;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class ErrorHandlingTest {

	Mono<Integer> div(int a, int b)
	{
		if(b==0)
		{
			return Mono.error(new RuntimeException("division by zero"));
			//Do not use
			//throw new RuntimeException("Division by zero");
		}
		else
		{
			return Mono.just(a/b);
		}
	}
	//@Test
	public void testHandleError()
	{
		div(10,2)
			.map(item->item * 3)
			
			/*
			.map(item->{
				throw new RuntimeException("Rethrow");
			})*/
			.subscribe(result->{
				log.info("Result "+result);
			},(err)->{
				log.info("Problem "+err.getMessage());
			});
	}
	//@Test
	public void testConcat()
	{
		Flux.just(100,200)
			.concat(Flux.error(new RuntimeException("Throw error")))
			.subscribe(result->{
				log.info("Result "+result);
			},(err)->{
				log.info("Problem "+err.getMessage());
			});
	}
	//@Test
	public void testThen()
	{
		Mono.just(100)
			.then(Mono.error(new RuntimeException("Throw error")))
			.subscribe(result->{
				log.info("Result "+result);
			},(err)->{
				log.info("Problem "+err.getMessage());
			});
	}
	//@Test
	public void testOnErrorReturn()
	{
		/*
		 * try
		 * {	
		 * 		result=	div(a,b)
		 * }
		 * catch(E)
		 * {
		 * 	result = 0;
		 * }
		 * */
		div(10,0)
			.onErrorReturn(0)//if(error)succes->0
			.subscribe(data->{
				log.info("Result "+data);
			});
	}
	//@Test
	public void testOnErrorComplete()
	{
		/*
		 * try
		 * {	
		 * 		result=	div(a,b)
		 * }
		 * catch(E)
		 * {
		 * 	//donothing
		 * }
		 * */
		div(10,0)
			.onErrorComplete()
			.map(item->{
				log.info("Item "+item);
				return item*2;
			})
			.subscribe(data->{
				log.info("Result "+data);
			},err->{
				log.info("Error "+err);
			});
	}
	//@Test
	public void testOnErrorResume()
	{
		/*
		 * try
		{
		
		}
		catch(Exce1)
		{
		
		}
		catch(Except2)
		 * */
		div(10,0)
			.onErrorResume(e->e instanceof RuntimeException,
					e-> Mono.just(10))
			.onErrorResume(e->Mono.just(100))
			.subscribe(data->{
				log.info("Result "+data);
			},err->{
				log.info("Error "+err);
			});
	}
	@Test
	public void testOnErrorMap()
	{
		/*
		 * try
		{
		
		}
		catch(Exce1)
		{
			throw new Excpetion();
		}
		*/
		div(10,0)
			.onErrorMap(e-> new RuntimeException("Rethrow"))
			.subscribe(data->{
				log.info("Result "+data);
			},err->{
				log.info("Error "+err);
			});
	}
}
