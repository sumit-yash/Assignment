package com.yash.java8.Question3;

import java.util.Scanner;

interface Demo{
	void print();
}

public class Check {

	public static void main(String[] args) {

		Demo c = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two number");
		int value = sc.nextInt();
		sc.nextLine();
		switch (value) {

		case 1:
			c = () -> {
				System.out.println("Enter second number");
				if (sc.nextInt() % 2 == 0) {
					System.out.println("number is even");
				} else {
					System.out.println("number is not even");
				}
			};
			c.print();
			break;
		case 2:
			System.out.println("Enter second number");
			c = () -> {
				int i = sc.nextInt();
				if (i % 2 != 0) {
					System.out.println("number is an odd");
				} else {
					System.out.println("number is not an odd");
				}
			};
			c.print();
			break;
		case 3:
			c = () -> {
				System.out.println("Enter second number");
				int i = sc.nextInt();
				int temp = i, num = i, count = 0, mul, sum = 0;

				while (temp != 0) {
					temp = temp / 10;
					count++;
				}
				while (i != 0) {
					int digit = i % 10;
					mul = 1;
					for (int j = 1; j <= count; j++) {
						mul = mul * digit;
					}
					sum = sum + mul;
					i = i / 10;
				}
				if (num == sum) {
					System.out.println("number is an armstrong");
				} else {
					System.out.println("number is not an armstrong");
				}

			};
			c.print();
			break;
		case 4:
			System.out.println("Enter second number");
			c = () -> {
				int i = sc.nextInt(), num, digit, rem = 0;
				num = i;
				while (i != 0) {
					digit = i % 10;
					rem = rem * 10 + digit;
					i = i / 10;
				}
				if (num == rem) {
					System.out.println("Number is Palindrom");
				} else {
					System.out.println("Number is not Palindrom");
				}
			};
			c.print();
			break;
		default:
			System.out.println("Enter valid number");
			break;

		}
	}
}
