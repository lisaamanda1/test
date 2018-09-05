package com.hx.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAspect {
	@DeclareParents(value = "com.hx.test.GreetingImpl", defaultImpl = LoveImpl.class)
	private Love love;
	
	@Around("execution(* com.hx.test.GreetingImpl.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("before doing");
		Object result = pjp.proceed();
		System.out.println("after doing");
		return result;
	}
}
