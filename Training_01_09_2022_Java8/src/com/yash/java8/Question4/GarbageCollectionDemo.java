package com.yash.java8.Question4;

import java.util.Arrays;
import java.util.List;

public class GarbageCollectionDemo {
	public static void main(String[] args) {

		List<String> list = Arrays.asList("Sumitaby", "ssa");

		StringBuilder sb = new StringBuilder();
		list.forEach(sb::append);
		System.out.println(sb.insert(4, ""));

		System.out.println(sb);
	}
}
