package com.yash.collectionDemo.Question9;

import java.util.Objects;

public class Employee {
	int empid;
	String empname;
	int salary;
	String deptname;
	String address;

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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", salary=" + salary + ", deptname=" + deptname
				+ ", address=" + address + "]";
	}

	public Employee(int empid, String empname, int salary, String deptname, String address) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.salary = salary;
		this.deptname = deptname;
		this.address = address;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		System.out.println("mod="+(empid%10));
		return empid%10;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(address, other.address) && Objects.equals(deptname, other.deptname)
				&& empid == other.empid && Objects.equals(empname, other.empname) && salary == other.salary;
	}
	
	

}
