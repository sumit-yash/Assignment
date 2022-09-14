package com.yash.project.Driver;

import java.util.List;
import java.util.Scanner;

import com.yash.project.entity.Student;
import com.yash.project.service.StudentService;
import com.yash.project.service.StudentServiceImpl;

public class Pilot {

	private static int rollNo = 0;
	private static String name = "";
	private static String address = "";
	private static Scanner sc = new Scanner(System.in);
	private static StudentService stuService = new StudentServiceImpl();

	private static void formatedStudent(Student stu) {
		System.out.println("---------------------------");
		System.out.println("Student roll No=" + stu.getRollNo());
		System.out.println("Student Name=" + stu.getName());
		System.out.println("Student Address=" + stu.getAddress());
		System.out.println("---------------------------");
	}

	private static void formatedListStudent(List<Student> list) {
		for (Student student : list) {
			formatedStudent(student);
		}
	}

	private static Student askForStudentDetails() {
		Student st = null;
		System.out.println("Please Enter Student roll No=");
		int rollNo = sc.nextInt();
		System.out.println("Please Enter Student Name=");
		String name = sc.next();
		System.out.println("Please Enter Student Address=");
		String address = sc.next();
		return st = new Student(rollNo, name, address);
	}

	private static void displayAddStudent() {
//		System.out.println("Please Enter Student roll No=");
//		int rollNo=sc.nextInt();
//		System.out.println("Please Enter Student Name=");
//		String name=sc.next();
//		System.out.println("Please Enter Student Address=");
//		String address=sc.next();
//		Student st=new Student(rollNo, name, address);
		int addStudent = stuService.addStudent(askForStudentDetails());
		if (addStudent > 0) {
			System.out.println("Student Added Successfully");
		} else {
			System.out.println("Error while adding student");
		}
	}

	private static void displayUpdateStudent() {
//		System.out.println("Please Enter Student roll No=");
//		int rollNo=sc.nextInt();
//		System.out.println("Please Enter Student Name=");
//		String name=sc.next();
//		System.out.println("Please Enter Student Address=");
//		String address=sc.next();
//		Student st=new Student(rollNo, name, address);
		System.out.println("Please Enter Student roll No=");
		int rollNo = sc.nextInt();
		Student availStudent = stuService.getStudent(rollNo);
		if (availStudent != null) {
			formatedStudent(stuService.modifyStudent(askForStudentDetails()));
		} else {
			System.out.println("Invalid Student rollNo");
		}
	}

	private static void displayGetStudent() {
		System.out.println("Please Enter Student roll No=");
		int rollNo = sc.nextInt();
//		Student receivedStudent = stuService.getStudent(rollNo);
//		System.out.println(receivedStudent);
		formatedStudent(stuService.getStudent(rollNo));
	}

	private static void displayRemoveStudent() {
		System.out.println("Please Enter Student roll No=");
		int rollNo = sc.nextInt();
		int removedStudent = stuService.removeStudent(rollNo);
		if (removedStudent > 0) {
			System.out.println("Student removed Successfully");
		} else {
			System.out.println("Error while removing student");
		}
	}

	private static void displayAllStudent() {
//		List<Student> listStudent = stuService.getAllStudents();
		formatedListStudent(stuService.getAllStudents());
	}

	public static void main(String[] args) {

		// add Student
		// stuService.addStudent(new Student(5,"vi","k"));

		// update Student
//		 Student st1=new Student(3, "lalit", "Jalgaon");
//		stuService.modifyStudent(st1);

		// remove Student
//		int removeStudent = stuService.removeStudent(2);
//		System.out.println("remove = "+removeStudent);

		// get Single Student
//		Student student = stuService.getStudent(2);
//		System.out.println("Single Student= " + student);

		// get All Students
//		List<Student> allStudents = stuService.getAllStudents();
//		for (Student st : allStudents) {
//			System.out.println(st);
//		}
		while (true) {
			System.out.println("*********************************************");
			System.out.println("******** Student Management System **********");
			System.out.println("*********************************************");
			System.out.println("Press");
			System.out.println("1 To Add Student");
			System.out.println("2 To Update Student");
			System.out.println("3 To View Perticular Student");
			System.out.println("4 To View All Students");
			System.out.println("5 To Delete Student");
			System.out.println("0 To Exit");

			int response = sc.nextInt();

			switch (response) {
			case 0: {
				System.out.println("Thank you for visit");
				System.exit(0);
				break;
			}
			case 1: {
				displayAddStudent();
				break;
			}
			case 2: {
				displayUpdateStudent();
				break;
			}
			case 3: {
				displayGetStudent();
				break;
			}
			case 4: {
				displayAllStudent();
				break;
			}
			case 5: {
				displayRemoveStudent();
				break;
			}
			default:
				System.out.println("Irrelevent entry please enter correct data");
			}
		}
	}
}
