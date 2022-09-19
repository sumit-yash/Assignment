package com.yash.java8.StreamApi_Question1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

public class Pilot {

	public static void main(String[] args) {
		
		   
        List<Item> l=new ArrayList<>();
        l.add(new Item(1, "Fan",LocalDateTime.of(2022, 4, 23, 4, 30), LocalDateTime.of(2023, 4, 11, 4, 22), 2000));
        l.add(new Item(2, "Cooler",LocalDateTime.of(2020, 5, 28, 8, 00), LocalDateTime.of(2020, 5, 2, 8, 10), 4000));
        l.add(new Item(3, "Chair",LocalDateTime.of(2021, 7, 21, 7, 20), LocalDateTime.of(2017, 7, 2, 7, 18), 8000));
        l.add(new Item(4, "Table",LocalDateTime.of(2012, 9, 13, 6, 37), LocalDateTime.of(2015, 7, 11, 6, 7), 3000));
        l.add(new Item(5, "Tubelight",LocalDateTime.of(2019, 9, 2, 6, 37), LocalDateTime.of(2020, 9, 12, 6, 37), 3000));
        l.add(new Item(6, "water bottle",LocalDateTime.of(2015, 10, 12, 6, 37),null, 10000));
    
        System.out.println("Find average of the given price of item");
        
        float price=(float) l.stream().mapToDouble(Item::getPrice).average().orElse(Double.NaN);
        System.out.println(price);
    
        System.out.println("Find the highest price of the given item");
        
        Item max=l.stream().map(v->v).max(Comparator.comparing(Item::getPrice)).orElseThrow(NoSuchElementException::new);
        System.out.println(max);
        
        System.out.println("Find the lowest price of the given item");
        
        Item min=l.stream().map(v->v).min(Comparator.comparing(Item::getPrice)).orElseThrow(NoSuchElementException::new);
        System.out.println(min);
    
        System.out.println("Find the item thoes have not Expiry date");
    
        List<Item> list=l.stream().filter(v->v.getDoe()==null).collect(Collectors.toList());
        System.out.println(list);
    
        System.out.println("store the name and price from list to set");
        
        Set<Item> value=l.stream().map(a->new Item(a.getIname(),a.getPrice())).collect(Collectors.toSet());
        for(Item i:value) {
        System.out.println(i.getIname()+" "+i.getPrice());
        }
        
        System.out.println("remove duplicate price from list of item");
        
        l.stream().map(s->s.getPrice()).distinct().forEach(System.out::println);
		
		
	}
}
