package com.yash.exceptions.Question5;

import java.util.Date;
import java.util.Scanner;

class BookingNotAllowedException extends Exception {
	String response;

	public BookingNotAllowedException(String response) {
		super(response);
	}
}

class PassangerDetailException extends Exception {

	public PassangerDetailException(String response) {
		super(response);
	}
}

public class TrainTicketBooking {
	public static void main(String[] args) {
//		getTicketDetails();
		int timeslot;
		int age;
		int num_of_bookings;

		Date d = new Date();
		Scanner sc = new Scanner(System.in);
		System.out.println("Dear customer - Please select 1 for normal booking\n" + "2 for Tatkal booking");
		int selection = sc.nextInt();

		try {
			if (selection == 1) {
				int time = d.getHours();
				if (time >= 23 && time <= 1) {
					System.out.println("tickets booking not allowed at this time");
					throw new PassangerDetailException("BookingNotAllowedException ");

				} else {
					System.out.println("Enter age of passenger");

				}
				int inputage = sc.nextInt();
				if (inputage > 5) {
					System.out.println("enter number of bookings");
					int number = sc.nextInt();
					if (number > 0 && number <= 6) {
						System.out.println(number + " booking are done");
					} else {
						System.out.println("only 6 are allowed");
						throw new PassangerDetailException("normalTicketBookingException");
					}

				} else {
					System.out.println("age exception");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			if (selection == 2) {

				// int time=d.getHours();
				if (d.getHours() >= 10 && d.getHours() <= 12) {
					System.out.println("Enter age of passenger");
					int inputage = sc.nextInt();
					if (inputage > 5) {
						System.out.println("Enter number of bookings");
						int number = sc.nextInt();
						if (number > 0 && number <= 4) {
							System.out.println(number + " booking are done");
						} else {
							System.out.println("only 4 are allowed");
							throw new PassangerDetailException("booking limit exceed");
						}

					} else {
						System.out.println("age exception");
					}

				} else {
					System.out.println("only 6 are allowed");
					throw new PassangerDetailException("TatkalTicketBookingException");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("enter correct number");
	}

	private static void getTicketDetails() {
		System.out.println("Please Select Type of ticket you want to reserve");
		System.out.println("Press 1 for Tatkal ");
		System.out.println("Press 2 for Normal");
		Scanner sc = new Scanner(System.in);
		int usrInput = sc.nextInt();
		System.out.println("Please enter total number of ticket you want to reserve");
		int ticketNum = sc.nextInt();
		try {
			if ((usrInput == 1 && ticketNum > 4) || (usrInput == 2 && ticketNum > 6)) {
				throw new BookingNotAllowedException("You Exceeded limit for booking ticket...");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
