//12.	WAP to sort array on the basis of unit place. 
//For example we are having following numbers:- 10,2,3,41,12,13,19,81,9. 
//Output will be 10,41,81,2,12,3,13,19,9.
package com.yash.ArrayDemo.Question12;

import java.util.Arrays;

public class UnitPlaceSort_12 {
	
	public static void main(String[] args) {
		int[] arr = { 10, 2, 3, 41, 12, 13, 19, 81, 9 };

		for (int i = 0; i < arr.length; i++) {
			int temp=0;
			for (int j = 0; j < arr.length-1; j++) {
				int prev_valUni=arr[i] % 10;
				int current_valUni=arr[j] % 10;
				if (prev_valUni<current_valUni) {
					if(arr[i]>arr[j]) {
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
					}
				}
			}
		}
		
		
		System.out.println(Arrays.toString(arr));
		
	}

}
