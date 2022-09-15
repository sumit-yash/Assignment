package com.yash.javaOOPsQuestions.Question10;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Employee_10 {
	private int empid;
	private String empname;
	private double empsalary;
	private String empaddress;
	private Date emp_dob;
	private Date emp_doj;

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public double getEmpsalary() {
		return empsalary;
	}

	public void setEmpsalary(double empsalary) {
		this.empsalary = empsalary;
	}

	public String getEmpaddress() {
		return empaddress;
	}

	public void setEmpaddress(String empaddress) {
		this.empaddress = empaddress;
	}

	public Date getEmp_dob() {
		return emp_dob;
	}

	public void setEmp_dob(Date emp_dob) {
		this.emp_dob = emp_dob;
	}

	public Date getEmp_doj() {
		return emp_doj;
	}

	public void setEmp_doj(Date emp_doj) {
		this.emp_doj = emp_doj;
	}

	public Employee_10(int empid, String empname, double empsalary, String empaddress, Date emp_dob, Date emp_doj) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.empsalary = empsalary;
		this.empaddress = empaddress;
		this.emp_dob = emp_dob;
		this.emp_doj = emp_doj;
	}

	public Employee_10() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee_10 [empid=" + empid + ", empname=" + empname + ", empsalary=" + empsalary + ", empaddress="
				+ empaddress + ", emp_dob=" + emp_dob + ", emp_doj=" + emp_doj + "]";
	}

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Enter Emp Id=");
		int empId = sc.nextInt();
		System.out.println("Enter Emp Name=");
		String empName = sc.next();
		System.out.println("Enter Emp Salary=");
		double empSalary = sc.nextDouble();
		System.out.println("Enter Emp Address=");
		String empAdd = sc.next();
		System.out.println("Enter Emp DOB In(dd/mm/yyyy)=");
		Date empDOB = formatter.parse(sc.next());
		System.out.println("Enter Emp DOJ In(dd-mm-yyyy)=");
		Date empDOJ = formatter.parse(sc.next());
		Employee_10 emp = new Employee_10(empId, empName, empSalary, empAdd, empDOB, empDOJ);
		System.out.println(emp.toString());
	}

}
