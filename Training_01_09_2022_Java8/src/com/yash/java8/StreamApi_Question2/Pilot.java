package com.yash.java8.StreamApi_Question2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Pilot {
	  public static void main(String[] args) {
	        
	        List<City> cs=Arrays.asList(
	                new City(101, "Mumbai", new State(1001, "Maharashtra"), 9.0f, 500000, 974),
	                new City(102, "Bhopal", new State(1001, "Madhya Pradesh"), 4.7f, 400000, 890),
	                new City(103, "Bhuwaneshwar", new State(1002, "Odisha"), 8.8f, 350000, 222),
	                new City(104, "Channai", new State(1002, "Tamil Nadu"), 9f, 650000, 874),
	                new City(105, "Raipur", new State(1003, "Chatisgadh"), 2f, 450000, 456),
	                new City(106, "Amravati", new State(1001, "Maharashtra"), 5.6f, 600000, 229)
	                );
	        
	        System.out.println("find city with less area and highest population");
	        List<City> value=cs.stream().sorted(Comparator.comparing(City::getPopulation).thenComparing(City::getArea_of_city).reversed()).limit(1).collect(Collectors.toList());
	        System.out.println(value);
	        
	        System.out.println("find city with high population index and high city area");
	        List<City> value1=cs.stream().sorted(Comparator.comparing(City::getPollutionIndex).thenComparing(City::getArea_of_city).reversed()).limit(1).collect(Collectors.toList());
	        System.out.println(value1);
	        
	        System.out.println("print city with less population index first");
	        List<City> value2=cs.stream().sorted(Comparator.comparing(City::getPollutionIndex)).collect(Collectors.toList());
	        System.out.println(value2);
	        
	        System.out.println("print city with lowest population index and lowest area");
	        List<City> value3=cs.stream().sorted(Comparator.comparing(City::getPollutionIndex).thenComparing(City::getArea_of_city)).limit(1).collect(Collectors.toList());
	        System.out.println(value3);
	        
	        System.out.println("count how many city in state");
	        long count=cs.stream().map(City::getCityname).count();
	        System.out.println(count);
	        
	        System.out.println("total area of each state");
	        long sum=cs.stream().collect(Collectors.summingLong(City::getArea_of_city));
	        System.out.println(sum);
	        
	    }


}
