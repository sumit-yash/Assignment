//WAP to sort Collection elements in ascending order.

package com.yash.collectionDemo.Question1;

import java.util.ArrayList;
import java.util.Collections;

public class SortDemo {
	
	public static void main(String[] args) {
		ArrayList<Integer> list=new ArrayList<>();
		list.add(2);
		list.add(10);
		list.add(8);
		list.add(15);
		list.add(18);
		list.add(1);
		
		System.out.println("List without Sort="+list);
		Collections.sort(list);
		System.out.println("Sorted List="+list);
	}

}
