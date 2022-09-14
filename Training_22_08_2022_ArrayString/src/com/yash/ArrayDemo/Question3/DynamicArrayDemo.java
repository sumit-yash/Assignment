package com.yash.ArrayDemo.Question3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DynamicArrayDemo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the size of the array  ");
		int size = sc.nextInt();
		String str[] = new String[size];

		System.out.println("Enter elements of the array (Strings)  ");
		for (int i = 0; i < size; i++) {
			str[i] = sc.next();
		}

		System.out.println(Arrays.toString(str));

		ArrayList<String> myList = new ArrayList<String>(Arrays.asList(str));
		System.out.println("Enter element that is to be added:");
		String element = sc.next();
		myList.add(element);
		str = myList.toArray(str);

		System.out.println(Arrays.toString(str));

	}

}
