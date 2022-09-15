package com.yash.collectionDemo.Question8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

public class Pilot {
	public static void main(String[] args) {

		
		 
		//pfFacility1
		ProductionFacility pd1=new ProductionFacility
				(101, "Developement", "wardha", 12,new String[] {"abc","def","aaa","mmm","nnnnn","gdttyuio"} ,LocalDate.of(2022, 8, 30));
		ProductionFacility pd2=new ProductionFacility
				(102, "Developement", "yavatmal", 13,new String[] {"pqr","stu","etryy","uytrf"} ,LocalDate.of(2022, 8, 29));
		ProductionFacility pd3=new ProductionFacility
				(103, "Developement", "kanpur", 14,new String[] {"vwx","yz"} ,LocalDate.of(2022, 8, 28));

		//pfFacility2
		ProductionFacility pd11=new ProductionFacility
				(201, "Testing", "amravati", 11,new String[] {"abc","def"} ,LocalDate.of(2022, 8, 20));
		ProductionFacility pd12=new ProductionFacility
				(202, "Testing", "washim", 12,new String[] {"pqr","stu","uytfd","yfd","kjhtr","uytrfd"} ,LocalDate.of(2022, 8, 19));
		ProductionFacility pd13=new ProductionFacility
				(203, "Testing", "buldhana", 13,new String[] {"vwx","yz"} ,LocalDate.of(2022, 8, 18));
		
		//pfFacility3
		ProductionFacility pd21=new ProductionFacility
				(301, "Production", "shegaon", 22,new String[] {"abc","def"} ,LocalDate.of(2022, 8, 10));
		ProductionFacility pd22=new ProductionFacility
				(302, "Production", "nagpur", 3,new String[] {"pqr","stu"} ,LocalDate.of(2022, 8, 9));
		ProductionFacility pd23=new ProductionFacility
				(303, "Production", "jalgaon", 14,new String[] {"vwx","yz"} ,LocalDate.of(2022, 8, 8));
		
		
		ArrayList<ProductionFacility> list=new ArrayList<>();
		list.add(pd1);
		list.add(pd2);
		list.add(pd3);
		
		list.add(pd11);
		list.add(pd12);
		list.add(pd13);
		
		list.add(pd21);
		list.add(pd22);
		list.add(pd23);
		
		
		// Print detail of facility on the basis of names
		basisOfName(list);
		
		// Print which facility is producing highest item. 
			HighestItem(list);
		
		// Print production detail of each facility on the basis of production date
			displayOnProductionDate(list);
	}

	private static void displayOnProductionDate(ArrayList<ProductionFacility> list) {
		Collections.sort(list,new Comparator<ProductionFacility>() {

			@Override
			public int compare(ProductionFacility pf1, ProductionFacility pf2) {
				LocalDate d1=pf1.getProd_date();
				LocalDate d2=pf2.getProd_date();
				if(d1.compareTo(d2)>0) {
					return 1;
				}else if(d2.compareTo(d1)>0) {
					return -1;
				}else {
				return 0;
				}
			}
		});
		System.out.println(list);
	}

	private static void HighestItem(ArrayList<ProductionFacility> list) {
		HashMap<String, Integer> map=new HashMap<>();
		int length=0;
		int val=0;
		String facName="";
		for (ProductionFacility pf : list) {
			length=pf.getItemnames().length;
			System.out.println("length="+length);
			if(map.containsKey(pf.getPro_facility_name())) {
				val=map.get(pf.getPro_facility_name());
				if(val>length) {
				map.put(pf.getPro_facility_name(), val);
				}else {
					map.put(pf.getPro_facility_name(), length);
				}
			}else {
				map.put(pf.getPro_facility_name(), length);
			}
		}
		
		for (Entry<String, Integer> m : map.entrySet()) {
			System.out.println(m.getKey()+" : "+m.getValue());
		}
	}
	
	
	private static void basisOfName(ArrayList<ProductionFacility> list) {
		Collections.sort(list,new Comparator<ProductionFacility>() {

			@Override
			public int compare(ProductionFacility o1, ProductionFacility o2) {
				String pfName1=o1.getPro_facility_name();
				String pfName2=o2.getPro_facility_name();
				return pfName2.compareTo(pfName1);
			}
		});
		System.out.println(list);
	}

	
}
