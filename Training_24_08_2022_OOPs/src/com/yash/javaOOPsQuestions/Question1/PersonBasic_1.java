package com.yash.javaOOPsQuestions.Question1;

public class PersonBasic_1 {
	
	
	public static void main(String[] args) {
		
		Department dept1=new Department(101, "IT");
		Department dept2=new Department(102, "Admin");
		Department dept3=new Department(103, "Security");
		Department dept4=new Department(104, "Software");
		
		Department[] deptArr=new Department[4];
		Employee emp1=new Employee(10001, "name1", "address1", "16082000", 2000, "16082021", "base1", dept1, 89788989, "name1@gmail.com");
		Employee emp2=new Employee(10002, "name2", "address2", "14091991", 3000, "17082021", "base2", dept2, 89788983, "name2@gmail.com");
		Employee emp3=new Employee(10003, "name3", "address3", "16101995", 4000, "18082021", "base3", dept3, 89788982, "name3@gmail.com");
		Employee emp4=new Employee(10004, "name4", "address4", "16112011", 5000, "19082021", "base4", dept4, 89788984, "name4@gmail.com");
	}

	
	
}
