//1.WAP to find third maximum number from list of numbers.
package com.yash.ArrayDemo.Question1;

import java.util.Arrays;
import java.util.Scanner;

public abstract class ThirdMaxDemo_1 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter index for max count :");
		int req=sc.nextInt();
		Integer[] intArr= {10,24,3,40,50,65,70,83,98,100};
		int temp=0;
		for(int i=0;i<intArr.length;i++) {
			for(int j=0;j<intArr.length;j++) {
				if(intArr[i]>intArr[j]) {
					temp=intArr[i];
					intArr[i]=intArr[j];
					intArr[j]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(intArr));
		System.out.println("for index "+req+" value = "+intArr[req-1]);
	}

}
