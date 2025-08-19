package com.wipro.travelagency.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect 
@Component 
@Slf4j
public class LoggingAspect {
	
	@Before("execution(* com.wipro.travelagency.controller.PackageController.addNewPackage(..))")
	public void logBeforeAddNewPackage() {
		log.warn("Logging something before addNewPackage endpoint");
	}
	
	@After("execution(* com.wipro.travelagency.controller.*.*(..))")
	public void logAfterControllerMethods() {
		log.info("A controller method has completed execution.");
	}
}
