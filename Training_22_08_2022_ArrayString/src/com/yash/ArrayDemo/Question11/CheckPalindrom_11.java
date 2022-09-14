//11.WAP to remove the String which is not palindrome string from the array of String.
package com.yash.ArrayDemo.Question11;

import java.util.Scanner;

public class CheckPalindrom_11 {
	public static void main(String[] args) {
		String[] strArr = { "abc", "pqp", "nitin", "wxyz", "1234" };
		String palindrome="";
		for (int i = 0; i < strArr.length; i++) {
			String rev = "";
			for (int j = strArr[i].length() - 1; j >= 0; j--) {
				rev = rev + strArr[i].charAt(j);
			}
			System.out.println("rev="+rev);
			if (strArr[i].equals(rev)) {
				palindrome+=strArr[i]+" ";
			} 
		}
		
		System.out.println("Palindrome Strings= "+palindrome);

	}

}
