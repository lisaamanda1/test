package com.hx.test;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		//Test.test1();
//		Test.test2();
//		Test.test3();
//		Test.test4();
//		Test.test5();
//		Test.test6();
		Test.test7();
	}
	
	public static void test1() {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(new GreetingImpl());
		proxyFactory.addAdvice(new GreetingBeforeAndAfter());
		Greeting greeting = (Greeting)proxyFactory.getProxy();
		greeting.sayHello();
	}
	
	public static void test2() {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(new GreetingImpl());
		proxyFactory.addAdvice(new GreetingAround());
		Greeting greeting = (Greeting)proxyFactory.getProxy();
		greeting.sayHello("man");
	}
	
	public static void test3() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		Greeting greeting = (Greeting)ac.getBean("greetingProxy");
		greeting.sayHello();
	}
	
	public static void test4() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		GreetingImpl greetingImpl = (GreetingImpl)ac.getBean("greetingProxy");
		Greeting greeting = (Greeting)ac.getBean("greetingProxy");
//		greetingImpl.sayHello();
		greeting.sayHello();
//		Love love = (Love)greetingImpl;
		Love love = (Love)greeting;
		love.display();
	}
	
	public static void test5() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		GreetingImpl greetingImpl = (GreetingImpl)ac.getBean("greetingProxy");
		greetingImpl.sayHello();
		greetingImpl.goodMorning();
	}
	
	public static void test6() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		GreetingImpl greetingImpl = (GreetingImpl)ac.getBean("greetingImpl");
		greetingImpl.sayHello();
		greetingImpl.goodMorning();
	}
	
	public static void test7() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		GreetingImpl greetingImpl = (GreetingImpl)ac.getBean("greetingImpl");
		greetingImpl.sayHello();
		greetingImpl.goodMorning();
		Love love = (Love)greetingImpl;
		love.display();
	}
}
