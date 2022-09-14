package com.yash.ioc.Question1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Pilot {
	
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext(
				"com/yash/ioc/Question1/applicationContext.xml");
		Employee bean = context.getBean("employee",Employee.class);
		System.out.println(bean);
		
	}

}
