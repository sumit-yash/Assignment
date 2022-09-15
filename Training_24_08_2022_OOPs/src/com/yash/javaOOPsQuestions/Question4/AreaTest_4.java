package com.yash.javaOOPsQuestions.Question4;

import java.util.Scanner;

class Area {
	double length;
	double width;
	double height;

	public Area(double length, double width, double height) {
		super();

	}

	public Area() {
		super();
		// TODO Auto-generated constructor stub
	}

	void areaOfTraingle(double leng, double wid, double height) {
		double Traingle = leng * wid * height;

		System.out.println("print area of tringle-" + Traingle);
	}

	void areaOfRectangle(double leng, double wid, double height) {

		double Rectangle = leng * wid;

		System.out.println("print area of Rectangle-" + Rectangle);
	}

	void areaOfSquare(double leng, double wid, double height) {

		double Square = leng * leng;
		System.out.println("print area of Square-" + Square);

	}

}

public class AreaTest_4 {
	public static void main(String[] args) {
		Area area = new Area();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the three side");

		double length = sc.nextDouble();
		double width = sc.nextDouble();
		double height = sc.nextDouble();

		if (length == width || length == height || width == height) {

			area.areaOfSquare(length, width, height);

		} else {

			area.areaOfRectangle(length, width, height);

			area.areaOfTraingle(length, width, height);

			if (height == length + width || length == height + width || height == length + width) {
				System.out.println("Right-Angle Triangle");
			} else {
				System.out.println("NotRight-Angle Triangle");
			}

		}
	}
}
