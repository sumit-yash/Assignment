package com.yash.exceptions.Question6;

import java.util.Scanner;

public class HelpToAssembleSystem {
	public static void main(String[] args) throws Exception {
		String sd = "";
		Scanner sc = new Scanner(System.in);

		System.out.println("select Assembled system");
		System.out.println("Select 1 for I3");
		System.out.println("Select 2 for I4");
		System.out.println("Select 3 for I5");
		System.out.println("Select 4 for dual core");
		System.out.println("Select 5 for quad core");
		System.out.println("Select 6 for core to dual processor ");
		int input = sc.nextInt();
		System.out.println("Enter RAM in GB");
		int ram = sc.nextInt();

		try {
			if (input == 1 || input == 2 || input == 3) {
				if (ram < 4) {
					System.out.println("exception LowerRAMSizeException ");
					throw new Exception("LowerRAMSizeException ");

				}

			}
			System.out.println("Enter h to buy HDD and s to buy SDD");
			sd = sc.next();

			if ((input == 1 || input == 2 || input == 3) && sd.equals("h")) {

//				System.out.println("exception MisMatchHardDiskException  ");
//				System.out.println(" HDD is also not supported with I series processor - HardDiskNotSupportedException ");
				throw new Exception("MisMatchHardDiskException");
			} 
		}
		catch (Exception e) {
			System.out.println(e);
		}

		try {
			if (input == 4 || input == 5 || input == 6) {
				if (ram < 1) {
//					System.out.println("exception LowerRAMException  ");
					throw new Exception("LowerRAMException  ");

				}

				if ((input == 4 || input == 5 || input == 6) && sd.equals("s")) {
					throw new Exception("HardDiskNotSupportedException ");
				}else {
					System.out.println("Now you can Purchase the Laptop");
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			
			sc.close();
		}
	}

}
