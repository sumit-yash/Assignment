//5.	An Array Contain different numbers
//you have to find how many are even, odd, perfect and prime 
package com.yash.ArrayDemo.Question5;

import java.util.Arrays;

public class EvenOddPerfectPrime_5 {

	public void checkEvenNumber(int[] evenArr) {
		String evenNumbers = "";
		for (int i = 0; i < evenArr.length; i++) {
			if (evenArr[i] % 2 == 0) {
				evenNumbers += evenArr[i] + " ";
			}
		}
		System.out.println("even numbers are= " + evenNumbers);
	}

	public void checkOddNumber(int[] oddArr) {
		String oddNumbers = "";
		for (int i = 0; i < oddArr.length; i++) {
			if (oddArr[i] % 2 != 0) {
				oddNumbers += oddArr[i] + " ";
			}
		}
		System.out.println("odd numbers are= " + oddNumbers);
	}

	public void checkPerfectNumber(int[] perfectArr) {
		
		String perfectNum="";
		for (int i = 0; i < perfectArr.length; i++) {
			int sum = 0;
			for (int j = 1; j <= perfectArr[i]/2; j++) {
				if (perfectArr[i] % j == 0) {
					sum += j;
				}
			}
			if(perfectArr[i]==sum) {
				perfectNum+=perfectArr[i]+" ";
			}
		}
		System.out.println("Perfect Numbers are = "+perfectNum);
	}

	public void checkPrimeNumber(int[] primeArr) {
		
		String primeNum = "";
		for (int i = 0; i < primeArr.length; i++) {
			int counter = 1;
			for (int j = 2; j <= primeArr[i]; j++) {
				if (primeArr[i] % j == 0) {
					counter++;
				}
			}
			if (counter == 2) {
				primeNum += primeArr[i] + " ";
			}
		}
		System.out.println("prime numbers are= " + primeNum);
	}

	public static void main(String[] args) {
		int[] intArr = { 2, 3, 4, 56, 76, 788, 54, 45, 67,28 };
		System.out.println(Arrays.toString(intArr));
		EvenOddPerfectPrime_5 eop = new EvenOddPerfectPrime_5();
		eop.checkEvenNumber(intArr);
		eop.checkOddNumber(intArr);
		eop.checkPrimeNumber(intArr);
		eop.checkPerfectNumber(intArr);
	}

}
