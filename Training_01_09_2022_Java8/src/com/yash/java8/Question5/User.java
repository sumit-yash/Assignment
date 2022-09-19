package com.yash.java8.Question5;

interface Check {

	void print();

}

public class User {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 6, 7, 8, 11, 13, 14, 15, 19, 20, 21, 21 };
		Check c = () -> {
			int j = 0;
			for (int i = 0; i < arr.length; i = ++j) {
				int count = 1;
				System.out.print(arr[i]);
				while (j < arr.length - 1) {

					if (arr[j + 1] - arr[j] == 1) {
						j++;
						count++;
						continue;
					} else {
						if (count == 1) {
							System.out.print(", ");
							break;
						}
						System.out.print("-" + arr[j] + ", ");
						break;
					}

				}
			}
			System.out.print("-" + arr[--j]);
		};
		c.print();
	}

}
