package com.yash.collectionDemo.Question9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Pilot {
	public static void main(String[] args) {
		Employee e1=new Employee(101, "sumit", 2000, "Software", "wardha");
		Employee e2=new Employee(102, "ajit", 2600, "Hr", "yavatmal");
		Employee e3=new Employee(103, "vinit", 6000, "Admin", "nanded");
		Employee e4=new Employee(104, "rajat", 9000, "It", "pune");
		Employee e5=new Employee(105, "ramesh", 7800, "It1", "pune");
		Employee e6=new Employee(106, "jay", 900, "It2", "pune");
		Employee e7=new Employee(107, "viru", 39000, "It3", "pune");
		Employee e8=new Employee(108, "niru", 9400, "It4", "pune");
		Employee e9=new Employee(109, "garu", 9700, "Admin", "pune");
		Employee e10=new Employee(110, "kalu", 9080, "software", "pune");
		
		Set<Employee> list=new HashSet<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		list.add(e7);
		list.add(e8);
		list.add(e9);
		list.add(e10);
		
		for (Employee e : list) {
			System.out.println(e);
		}
	}
}
