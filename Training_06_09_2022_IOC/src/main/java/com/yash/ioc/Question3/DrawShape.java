package com.yash.ioc.Question3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawShape {
	
	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("/com/yash/ioc/Question3/applicationContextQ3.xml");
		Shape ps=context.getBean("p1",Parallelogram.class);
		Shape rs=context.getBean("r1",Rectangle.class);
		Shape ts=context.getBean("t1",Triangle.class);
		
		ps.draw();
		rs.draw();
		ts.draw();
		
	}
}
