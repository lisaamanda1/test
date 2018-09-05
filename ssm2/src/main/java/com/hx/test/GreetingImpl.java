package com.hx.test;

import org.springframework.stereotype.Component;

@Component
public class GreetingImpl implements Greeting {

	@Override
	public void sayHello() {
		System.out.println("Hello World£¡");
	}
	
	@Override
	public String sayHello(String str) {
		return str;
	}
	
	public void goodMorning() {
		System.out.println("good morning");
	}
	
	public void goodNight() {
		System.out.println("good night");
	}
}
