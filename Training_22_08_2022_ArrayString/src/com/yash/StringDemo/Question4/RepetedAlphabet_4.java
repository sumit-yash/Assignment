//4.	WAP to print the number of alphabets repeated in the given string.

package com.yash.StringDemo.Question4;

import java.util.HashMap;

public class RepetedAlphabet_4 {

	public static void main(String[] args) {
		RepetedAlphabet_4 rp = new RepetedAlphabet_4();
		rp.repetedAlphabet("nitin");
	}

	private void repetedAlphabet(String reqString) {
		char[] ch = reqString.toLowerCase().toCharArray();
		
		for (int i = 0; i < ch.length; i++) {
			int counter = 1;
			for (int j = 0; j < ch.length; j++) {
				if(i==j) {
					break;
				} 
				if (ch[i] == ch[j]) {
					counter++;
				}
			}
			if(counter>1)
				System.out.println("for "+ch[i]+" count= "+counter);
		}
	}

}
