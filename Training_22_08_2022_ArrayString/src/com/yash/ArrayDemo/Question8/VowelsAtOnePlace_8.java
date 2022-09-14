//8.	You are given a sequence of Character in the form of Array. 
//Now you have to put all vowels and consonants together in the array.
package com.yash.ArrayDemo.Question8;

import java.util.Arrays;

public class VowelsAtOnePlace_8 {

	void checkVowels(char arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] == 'a' || arr[j] == 'e' || arr[j] == 'i' || arr[j] == 'o' || arr[j] == 'u') {
					char temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}

	/* Prints the array */
	void printArray(char arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {

		VowelsAtOnePlace_8 ob = new VowelsAtOnePlace_8();
		String str = "fkowlmsimf";
		char arr[] = str.toCharArray();
		ob.checkVowels(arr);
		System.out.println("Sorted array");
		ob.printArray(arr);

	}
}