//2.WAP to find duplicate numbers and there counting from list of numbers.
package com.yash.ArrayDemo.Question2;

public class DuplicateNumber_2 {

	public static void main(String[] args) {
		int[] numArr = { 1, 22, 33, 44, 5, 66, 8, 22, 44, 5 ,5};
		
		for (int i = 0; i < numArr.length; i++) {
			int counter = 1;
			for (int j = 0; j < numArr.length; j++) {
				if(i==j) {
					break;
				}
				if (numArr[i] == numArr[j]) {
					counter++;
				}
			}
			if(counter >1)
			System.out.println("for numArr[" + i + "]=" + numArr[i] + " count= " + counter);
		}
	}

}
