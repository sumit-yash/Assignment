package com.yash.collectionDemo.Question4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class DecendingOrder implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return -1;
	}
	
}

public class RemoveDuplicateName{
	
	public static void main(String[] args) {
		List<String> stringList=new ArrayList<>();
		stringList.add("abc");
		stringList.add("pqrs");
		stringList.add("xyz");
		stringList.add("lmn");
		stringList.add("abc");
		stringList.add("abc");
		
		HashSet<String> set=new HashSet<>(stringList);
		List<String> l=new ArrayList<>(set);
		Collections.sort(l,Collections.reverseOrder());
		System.out.println(l);
	}


	

	
}
