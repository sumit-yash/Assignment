package com.yash.javaOOPsQuestions.Question6;

public class MaximumNumber {

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

		System.out.println("Third maximum number is: " + a[2]);
	}
}
