package com.yash.collectionDemo.Question2;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearchDemo {
	public static void main(String[] args) {

		ArrayList<Integer> l = new ArrayList<Integer>();

		l.add(5);
		l.add(10);
		l.add(15);
		l.add(20);
		l.add(25);
		l.add(30);
		l.add(35);

		System.out.println("List of array: " + l);

		int val = 20;

		int result = Collections.binarySearch(l, val);

		if (result == -1)
			System.out.println("Element not present");
		else
			System.out.println("The Element " + val + " is found at " + "index " + result);
	}
}
