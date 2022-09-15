package com.yash.collectionDemo.Question5;

import java.util.Collections;
import java.util.Vector;

public class VectorSort {
	public static void main(String[] args) {
		Vector<String> v=new Vector<>();
		v.add("chair");
		v.add("table");
		v.add("fan");
		v.add("gyser");
		Collections.sort(v);
		System.out.println(v);
	}
}
