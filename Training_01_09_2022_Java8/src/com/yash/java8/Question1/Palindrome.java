package com.yash.java8.Question1;

import java.util.Arrays;

interface Check{
	void print();
}

public class Palindrome {

	public static void main(String[] args) {

		String number = "12321";
		char ch[] = number.toCharArray();
		char temp[] = new char[number.length()];

		Check c = () -> {
			int j = 0;
			for (int i = ch.length - 1; i >= 0; i--) {
				temp[j++] = ch[i];
			}
			if (Arrays.equals(ch, temp)) {
				System.out.println("Enter number is palindrom");
			} else {
				System.out.println("Enter number is not palindrom");
			}
		};
		c.print();

	}

}
