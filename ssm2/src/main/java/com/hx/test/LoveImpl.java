package com.hx.test;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

@Component
public class LoveImpl extends DelegatingIntroductionInterceptor implements Love {

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		return super.invoke(mi);
	}

	@Override
	public void display() {
		System.out.println("I Love You");
	}

}
