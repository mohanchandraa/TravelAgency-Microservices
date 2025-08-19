package com.wipro.travelagency.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect 
@Component 
@Slf4j
public class LoggingAspect {
	
	@After("execution(* com.wipro.travelagency.controller.*.*(..))")
	public void logAfterControllerMethods() {
		log.info("A controller method has completed execution.");
	}
}
