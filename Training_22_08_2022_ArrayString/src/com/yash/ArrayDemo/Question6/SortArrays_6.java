//6.	Suppose that you are having an array of size N. 
//now your task is to sort the half array that is from 0 to N/2 in ascending order 
//and N/2+1 to N in descending order. 
package com.yash.ArrayDemo.Question6;

import java.util.Arrays;

public class SortArrays_6 {

	public static void main(String[] args) {
		int[] testArr= {57,68,61,4,7,9,51,1,19,27,34,39,46,49,53,200,300};
		int size=testArr.length/2;
		System.out.println("size="+size);
		int temp=0;
		for(int i=0;i<=size;i++) {
			for(int j=0;j<size;j++) {
				if(testArr[i]<testArr[j]) {
					temp=testArr[i];
				testArr[i]=testArr[j];
					testArr[j]=temp;
				}
			}
		}
		for(int i=size+1;i<testArr.length;i++) {
			for(int j=size+1;j<testArr.length;j++) {
				if(testArr[i]>testArr[j]) {
					temp=testArr[i];
					testArr[i]=testArr[j];
					testArr[j]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(testArr));
	}

}
