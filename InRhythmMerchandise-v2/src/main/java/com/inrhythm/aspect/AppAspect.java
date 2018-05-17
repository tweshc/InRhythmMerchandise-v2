/*
 * 
 */
package com.inrhythm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.inrhythm.exception.IncorrectInputException;

/**
 * The Class AppAspect.
 */
@Configuration
@Aspect
public class AppAspect {
	
	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * After throwing custom exception args.
	 *
	 * @param jp the jp
	 * @param e the e
	 */
	@AfterThrowing(pointcut = "com.inrhythm.aspect.CommonPointcuts.allMethodsArgs()", throwing = "e")
	public void afterThrowingCustomExceptionArgs(JoinPoint jp, IncorrectInputException e) {
		logger.error("INCORRECTINPUTEXCEPTION THROWN: " + e.getMessage());
	}
	
	/**
	 * After throwing exception args.
	 *
	 * @param jp the jp
	 * @param e the e
	 */
	@AfterThrowing(pointcut = "com.inrhythm.aspect.CommonPointcuts.allMethodsArgs()", throwing = "e")
	public void afterThrowingExceptionArgs(JoinPoint jp, Exception e) {
		logger.error("Exception THROWN: " + e.getMessage());
	}
	
	/**
	 * After throwing custom no args.
	 *
	 * @param jp the jp
	 * @param e the e
	 */
	@AfterThrowing(pointcut = "com.inrhythm.aspect.CommonPointcuts.allMethodsNoArgs()", throwing = "e")
	public void afterThrowingCustomNoArgs(JoinPoint jp, IncorrectInputException e) {
		logger.error("INCORRECTINPUTEXCEPTION THROWN: " + e.getMessage());
	}
	
	/**
	 * After throwing exception no args.
	 *
	 * @param jp the jp
	 * @param e the e
	 */
	@AfterThrowing(pointcut = "com.inrhythm.aspect.CommonPointcuts.allMethodsNoArgs()", throwing = "e")
	public void afterThrowingExceptionNoArgs(JoinPoint jp, Exception e) {
		logger.error("Exception THROWN: " + e.getMessage());
	}
	
	/**
	 * Before all methods with no args.
	 *
	 * @param jp the jp
	 */
	@Before("com.inrhythm.aspect.CommonPointcuts.allMethodsNoArgs()")
	public void beforeAllMethodsWithNoArgs(JoinPoint jp) {
		logger.info("Entering: " + jp.toShortString());
	}
	
	/**
	 * After all methods with no args.
	 *
	 * @param jp the jp
	 */
	@After("com.inrhythm.aspect.CommonPointcuts.allMethodsNoArgs()")
	public void afterAllMethodsWithNoArgs(JoinPoint jp) {
		logger.info("Exiting: " + jp.toShortString());
	}
	
	/**
	 * Before all methods with args.
	 *
	 * @param jp the jp
	 */
	@Before("com.inrhythm.aspect.CommonPointcuts.allMethodsArgs()")
	public void beforeAllMethodsWithArgs(JoinPoint jp) {
		logger.info("Entering: " + jp.toShortString());
		logger.info("Args passed: ");
		for(Object o : jp.getArgs()) {
			logger.info(o.toString());
		}
	}
	
	/**
	 * After all methods with args.
	 *
	 * @param jp the jp
	 */
	@After("com.inrhythm.aspect.CommonPointcuts.allMethodsArgs()")
	public void afterAllMethodsWithArgs(JoinPoint jp) {
		logger.info("Exiting: " + jp.toShortString());
	}
	
}
