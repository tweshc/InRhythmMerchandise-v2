package com.inrhythm.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcuts {
	
	@Pointcut("execution(* com.inrhythm.*.*.*())")
	public void allMethodsNoArgs(){}
	
	@Pointcut("execution(* com.inrhythm.*.*.*(..))")
	public void allMethodsArgs(){}
	
	
	
	@Pointcut("execution(* com.inrhythm.controller.*.*())")
	public void controllerExecutionNoArgs(){}
	
	@Pointcut("execution(* com.inrhythm.controller.*.*(..))")
	public void controllerExecutionArgs(){}
	
	
	
	@Pointcut("execution(* com.inrhythm.service.*.*())")
	public void businessLayerExecutionNoArgs(){}
	
	@Pointcut("execution(* com.inrhythm.service.*.*(..))")
	public void businessLayerExecutionArgs(){}
	
	
	
	@Pointcut("execution(* com.inrhythm.repository.*.*())")
	public void dataLayerExecutionNoArgs(){}
	
	@Pointcut("execution(* com.inrhythm.repository.*.*(..))")
	public void dataLayerExecutionArgs(){}
	

}
