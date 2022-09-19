package com.yash.java8.Question6;

import java.util.Scanner;

interface PatternInterface {
	void displayPattern(int row);
}

public class Pattern {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the alphabet needed to in the pattern");
		int value = Character.toUpperCase((sc.nextLine().charAt(0)));
		int row = value - 65;
		PatternInterface p = (r) -> {

			int alphabet = 65;
			for (int i = 0; i <= row; i++) {

				for (int j = 0; j <= row - i; j++) {
					System.out.print((char) (alphabet + j));
				}

				for (int k = 1; k <= i * 2 - 1; k++) {
					System.out.print(" ");
				}

				for (int l = row - i; l >= 0; l--) {

					if (l != row)
						System.out.print((char) (alphabet + l));
				}
				System.out.println();
			}

		};
		p.displayPattern(row);
	}
}
