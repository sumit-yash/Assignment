package com.yash.javaOOPsQuestions.Question6;

import java.util.Arrays;

public class NewMaximum extends MaximumNumber {

	@Override
	void maximum(int a[]) {
		int temp = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(a));

		System.out.println("fourth maximum number is: " + a[3]);
	}

	void max(int a[]) {
		int temp = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(a));

		System.out.println("maximum number is: " + a[0]);
	}

}
