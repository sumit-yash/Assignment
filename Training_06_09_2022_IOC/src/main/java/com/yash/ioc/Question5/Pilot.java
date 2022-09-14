package com.yash.ioc.Question5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Pilot {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/com/yash/ioc/Question5/applicationContext5.xml");
		SetterMessage bean = context.getBean("sm",SetterMessage.class);
		System.out.println(bean);
	}
}
