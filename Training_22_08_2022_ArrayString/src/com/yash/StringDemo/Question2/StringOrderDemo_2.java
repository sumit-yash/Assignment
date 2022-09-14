//2.WAP to print the all alphabets of string in ascending and descending order.

package com.yash.StringDemo.Question2;

import java.util.Arrays;
import java.util.TreeSet;

public class StringOrderDemo_2 {

	public String ascendingOrder(String reqString) {
		reqString = reqString.toLowerCase();
		String returnStr = "";

		System.out.println("Ascending Order=");
		char[] orderArray = orderArray(reqString.toCharArray());
		for (char c : orderArray) {
			returnStr += c;
		}
		return returnStr;
	}

	public char[] orderArray(char[] rtnCharArray) {
		char temp;
		for (int i = 0; i < rtnCharArray.length; i++) {
			for (int j = 0; j < rtnCharArray.length; j++) {
				if (rtnCharArray[i] < rtnCharArray[j]) {
					temp = rtnCharArray[j];
					rtnCharArray[j] = rtnCharArray[i];
					rtnCharArray[i] = temp;
				}
			}
		}
		return rtnCharArray;
	}

	public String descendingOrder(String rtnStr) {
		rtnStr = rtnStr.toLowerCase();
		String returnStr = "";
		System.out.println("Decending Order=");

		char[] orderArray = orderArray(rtnStr.toCharArray());

		for (int i = orderArray.length - 1; i >= 0; i--) {
			returnStr += orderArray[i];
		}
		return returnStr;
	}

	public static void main(String[] args) {

		StringOrderDemo_2 sod = new StringOrderDemo_2();
		System.out.println(sod.ascendingOrder("sUmit"));
		System.out.println(sod.descendingOrder("sumIt"));

	}

}
