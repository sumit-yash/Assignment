package com.yash.ioc.Question2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Pilot {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/yash/ioc/Question2/applicationContext2.xml");
		PrintMessage bean = context.getBean("pm",PrintMessage.class);
		System.out.println(bean);
	}
}
