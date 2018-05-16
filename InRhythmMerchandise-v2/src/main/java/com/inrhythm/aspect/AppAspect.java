package com.inrhythm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.inrhythm.exception.IncorrectInputException;

@Configuration
@Aspect
public class AppAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@AfterThrowing(pointcut = "com.inrhythm.aspect.CommonPointcuts.allMethodsArgs()", throwing = "e")
	public void afterThrowingCustomExceptionArgs(JoinPoint jp, IncorrectInputException e) {
		logger.error("INCORRECTINPUTEXCEPTION THROWN: " + e.getMessage());
	}
	
	@AfterThrowing(pointcut = "com.inrhythm.aspect.CommonPointcuts.allMethodsArgs()", throwing = "e")
	public void afterThrowingExceptionArgs(JoinPoint jp, Exception e) {
		logger.error("Exception THROWN: " + e.getMessage());
	}
	
	@AfterThrowing(pointcut = "com.inrhythm.aspect.CommonPointcuts.allMethodsNoArgs()", throwing = "e")
	public void afterThrowingCustomNoArgs(JoinPoint jp, IncorrectInputException e) {
		logger.error("INCORRECTINPUTEXCEPTION THROWN: " + e.getMessage());
	}
	
	@AfterThrowing(pointcut = "com.inrhythm.aspect.CommonPointcuts.allMethodsNoArgs()", throwing = "e")
	public void afterThrowingExceptionNoArgs(JoinPoint jp, Exception e) {
		logger.error("Exception THROWN: " + e.getMessage());
	}
	
	
	
	@Before("com.inrhythm.aspect.CommonPointcuts.allMethodsNoArgs()")
	public void beforeAllMethodsWithNoArgs(JoinPoint jp) {
		logger.info("Entering: " + jp.toShortString());
	}
	
	@After("com.inrhythm.aspect.CommonPointcuts.allMethodsNoArgs()")
	public void afterAllMethodsWithNoArgs(JoinPoint jp) {
		logger.info("Exiting: " + jp.toShortString());
	}
	
	@Before("com.inrhythm.aspect.CommonPointcuts.allMethodsArgs()")
	public void beforeAllMethodsWithArgs(JoinPoint jp) {
		logger.info("Entering: " + jp.toShortString());
		logger.info("Args passed: ");
		for(Object o : jp.getArgs()) {
			logger.info(o.toString());
		}
	}
	
	@After("com.inrhythm.aspect.CommonPointcuts.allMethodsArgs()")
	public void afterAllMethodsWithArgs(JoinPoint jp) {
		logger.info("Exiting: " + jp.toShortString());
	}
	
}
