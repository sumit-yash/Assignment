//7.	WAP to find the LCM and HCF of array numbers.
package com.yash.ArrayDemo.Question7;

import java.util.Scanner;

public class LCMAndHCF_7 {

	public static void main(String[] args) {
		int temp_a, temp_b, temp, HCF, LCM;

		System.out.println("First Number: ");
		int fname = new Scanner(System.in).nextInt();
		System.out.println("Second Number: ");
		int sname = new Scanner(System.in).nextInt();

		temp_a = fname;
		temp_b = sname;

		while (temp_b != 0) {
			temp = temp_b;
			temp_b = temp_a % temp_b;
			temp_a = temp;
		}

		HCF = temp_a;
		LCM = (fname*sname) / HCF;

		System.out.println("HCF = " + HCF);
		System.out.println("LCM =  " + LCM);
	}

}
