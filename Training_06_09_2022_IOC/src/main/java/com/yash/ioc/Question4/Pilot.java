package com.yash.ioc.Question4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Pilot {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/com/yash/ioc/Question4/applicationContext4.xml");
		ConstructorMessage bean = context.getBean("cm",ConstructorMessage.class);
		System.out.println(bean);
	}
}
