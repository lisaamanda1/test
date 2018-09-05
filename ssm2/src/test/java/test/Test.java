package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hx.controller.UserController;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		UserController uc = (UserController)ac.getBean("userController");
		uc.action();
	}
}
