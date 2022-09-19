package com.yash.java8.Question10;

import java.util.HashMap;
import java.util.Scanner;

public class PredicateDemo {
	
	 public static void main(String[] args) {
	        
	        Scanner sc = new Scanner(System.in);
	        HashMap< Integer, Double> map = new HashMap<>();
	        Integer year = null;
	        Double sell = null;
	        System.out.println("please enter year and sell ( in Crores)");
	        for(int i=1;i<6;i++)
	        {
	            System.out.println("Enter year");
	             year = sc.nextInt();
	            System.out.println("Enter sell");
	            sell = sc.nextDouble();
	            map.put(year, sell);
	        }
	        
	        map.put((year+1), (sell+0.5));
	        map.put((year+2), (sell+1));
	        map.put((year+3), (sell+1.5));
	        
	        System.out.println("Your data " +map);
	        System.out.println("enter year for predication of sell for any given year");
	        int input=sc.nextInt();
	        map.forEach((k,v)->System.out.println("Year is "+k +" sell is "+v));
	        
	        System.out.println(map.get(input));
	        
	    }

}
