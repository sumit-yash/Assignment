package com.yash.exceptions.Question1;

/*
 * 1.exception will be thrown when user is failed in more than 1 subject.
 *2.You also need to throw exception when user mistakenly input the negative marks.
 *3.If user total score is less than 40% you need to through fail exception
*/

import java.util.Scanner;

class ResultException extends RuntimeException {

	String response;

	public ResultException(String response) {
		super(response);
	}

}

class NegativeValueException extends RuntimeException {
	String response;

	public NegativeValueException() {
		super();
	}

	public NegativeValueException(String response) {
		super(response);
	}

}

public class Pilot {

	private void getResult() {
		StudentResult stuResult = null;
		Student student = null;
		int phMrks = 0;
		int mathMrks = 0;
		int cheMrks = 0;
		int rollNo = 0;
		String name = "";
		String address = "";
		Scanner sc = new Scanner(System.in);
		try {

			System.out.println("Please Enter Name=");
			name = sc.next();
			System.out.println("Please Enter Address=");
			address = sc.next();
			System.out.println("Please Enter Roll No=");
			rollNo = sc.nextInt();
			System.out.println("Please Enter Physics Marks");
			phMrks = sc.nextInt();
			System.out.println("Please Enter Maths Marks=");
			mathMrks = sc.nextInt();
			System.out.println("Please Enter Chemistry Marks=");
			cheMrks = sc.nextInt();
			if (rollNo < 0 || phMrks < 0 || mathMrks < 0 || cheMrks < 0) {
				throw new NegativeValueException("Value can not be negative, Please enter positive value");
			}
			if ((name.isBlank() && name.isEmpty()) || (address.isBlank() && address.isEmpty())) {
				throw new NegativeValueException("Value can not be blank or null, Please enter appropriate value");
			}

		} catch (Exception e) {
			System.out.println(e);
//
		}
		sc.close();
		stuResult = new StudentResult(phMrks, cheMrks, mathMrks);
		student = new Student(rollNo, name, address, stuResult);
		diagnoseResults(student);
	}

	private void diagnoseResults(Student student) {
		int chMrk = student.getSrobj().getChemistryMarks();
		int phMrk = student.getSrobj().getPhysicsMarks();
		int mthMrk = student.getSrobj().getMathsMarks();
		int counter = 0;
		if (chMrk < 40) {
			counter++;
		}
		if (phMrk < 40) {
			counter++;
		}
		if (mthMrk < 40) {
			counter++;
		}
		int avg = ((chMrk + phMrk + mthMrk) * 100) / 300;
		System.out.println("Avg=" + avg);
		if (counter > 1) {
			throw new ResultException("Student scored less than 40 marks for 1 or more than 1 subject: ");
		}
		if (avg < 40) {
			throw new ResultException("Student scored less than 40 marks ....Fail ");
		} else {
			System.out.println("Passed");
		}

	}

	public static void main(String[] args) {
//		StudentResult result1 = new StudentResult(66, 70, 89);
//		StudentResult result2=new StudentResult(56, 90, 60);
//		StudentResult result3=new StudentResult(46, 60, 59);
//		StudentResult result4=new StudentResult(36, 50, 79);
//
//		Student student1=new Student(101, "sumit", "wardha", result1);
//		Student student2=new Student(102, "ajit", "nagpur", result2);
//		Student student3=new Student(103, "vijay", "yavatmal", result3);
//		Student student4=new Student(104, "mukul", "salod", result4);

		Pilot p = new Pilot();
		p.getResult();

	}

}
