package com.azhya.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
private static Logger log = Logger.getLogger(LoggingAspect.class);
	
	//@Before(value="execution(* com.azhya.services.UserServiceImpl.getAllUsers(..))")
	@Before(value="execution(* com.azhya.*.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		log.info(String.format("Before advice for: [ %s : %s ]", 
				joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName()));
		
		Object[] args = joinPoint.getArgs();
		for(Object arg: args) {
			log.info("Argument: " + arg);
		}
	}
	
	@After(value="execution(* com.azhya.*.*.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		log.info(String.format("After advice for: [ %s : %s ]", 
				joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName()));
	}

}
