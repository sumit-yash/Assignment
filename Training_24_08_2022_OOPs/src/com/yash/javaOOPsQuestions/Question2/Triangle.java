package com.yash.javaOOPsQuestions.Question2;

import java.util.Scanner;

public class Triangle implements Shape {
	int x1, y1, x2, y2, x3,y3;

	double a, b, c;

	@Override
	public double area() {
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the co-ordinate of x1 and y1");
	    x1=sc.nextInt();
	    y1=sc.nextInt();
	    
	    System.out.println("Enter the co-ordinate of x2 and y2");
	    x2=sc.nextInt();
	    y2=sc.nextInt();
	    
	    System.out.println("Enter the co-ordinate of x3 and y3");
	    x3=sc.nextInt();
	    y3=sc.nextInt();

	    double a1=(x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
	    a=Math.sqrt(a1);
	    
	    double b1=(x3-x2)*(x3-x2)+(y3-y2)*(y3-y2);
	    b=Math.sqrt(b1);
	    
	    double c1=(x3-x1)*(x3-x1)+(y3-y1)*(y3-y1);
	    c=Math.sqrt(c1);
	    
	    double s=((a+b+c)/2);
	    System.out.println("Perimeter of Triagle "+(a+b+c));
	    
	    double area=s*(s-a)*(s-b)*(s-c);
	    
	    return area;
	}

	public static void main(String[] args) {
	    Shape tringle=new Triangle();
	    System.out.println("Area of Triangle "+tringle.area());
	}
}
