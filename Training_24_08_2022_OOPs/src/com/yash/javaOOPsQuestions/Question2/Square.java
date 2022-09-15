package com.yash.javaOOPsQuestions.Question2;

import java.util.Scanner;

public class Square implements Shape{
	
	int xb1, yb1, xb2, yb2;
	int xl1, xl2, yl1, yl2;
	double length, breath;

	@Override
	public double area() {
		 
		Scanner sc = new Scanner(System.in);
		System.out.println("Coordinate of Length of x1 axis");
		int xl1 = sc.nextInt();
		int yl1 = sc.nextInt();

		System.out.println("Coordinate of Length of x2 axis");
		int xl2 = sc.nextInt();
		int yl2 = sc.nextInt();

		double length1 = ((xl2 - xl1) * (xl2 - xl1)) + ((yl2 - yl1) * (yl2 - yl1));
		length = Math.sqrt(length1);
		System.out.println("Coordinate of Length of y1 axis");
		xb1 = sc.nextInt();
		yb1 = sc.nextInt();

		System.out.println("Coordinate of Length of y2 axis");
		xb2 = sc.nextInt();
		yb2 = sc.nextInt();

		double breath1 = ((xb1 - xl1) * (xb1 - xl1)) + ((yb1 - yl1) * (yb1 - yl1));
		// System.out.println(breath=Math.sqrt(breath1));

		breath = Math.sqrt(breath1);
		System.out.println(length + " " + breath + " ");
		return length * breath;
		}

		public static void main(String[] args) {
		Shape square = new Square();
		System.out.println(square.area());
		}
}
