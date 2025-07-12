package com.turing.javaee7.jpa.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;


import lombok.extern.slf4j.Slf4j;

@Configuration  
@Aspect  
@Slf4j
//For the sake of tutorial only
public class LoggingAspect {
	 //Before->Advice
	 //execution Join point
	 //(* com.turing.javaee7.jpa.controller.*.*(..)) pointcut
	 @Before("execution(* com.turing.javaee7.jpa.controller.*.*(..))")
	 public void logBefore(JoinPoint joinPoint){  
	        log.info("In Aspect before "+joinPoint.toString());  
	 }  
	 @After("execution(* com.turing.javaee7.jpa.controller.*.*(..))")
	 public void logAfter(JoinPoint joinPoint){  
	        log.info("In Aspect After "+joinPoint.toString());  
	 }
	 @Before("within(com.turing.javaee7.jpa.controller..*)")
	 public void withinBefore(JoinPoint joinPoint){  
	        log.info("In Aspect within before "+joinPoint.toString());  
	 }  
 	@AfterReturning(
    		pointcut="execution(* com.turing.javaee7.jpa.controller.*.*(..))",
    		returning="retVal")
	public void doAccessCheck(Object retVal) {
		log.info("In Aspect After Return RetValue "+retVal);
	}
    @AfterThrowing(value="execution(* com.turing.javaee7.jpa.controller.*.*(..))",throwing = "exception")
		public void doRecoveryActions(Exception exception) {
    	log.info("In Aspect @AfterThrowing "+exception.getMessage());
	}
    @Around("execution(* com.turing.javaee7.jpa.service.*.*(..))")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
    	log.info("In Aspect @Around before "+pjp.toString());
		
    	for(Object param : pjp.getArgs())
    	{
    		log.info("Paramter "+param);
    	}
    	log.info("Proxy "+ pjp.getThis());
    	log.info("Target "+ pjp.getTarget());
    	log.info("Siganture name "+ pjp.getSignature().getName());
    	log.info("getDeclaringType "+ pjp.getSignature().getDeclaringType());
    	Object retVal =null;
    	retVal = pjp.proceed();
		
		log.info("In Aspect @Around after "+pjp.toString() +" return "+retVal);
		return retVal;
	}
}
