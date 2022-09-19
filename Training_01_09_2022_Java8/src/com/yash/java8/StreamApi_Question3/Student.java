package com.yash.java8.StreamApi_Question3;

import java.time.LocalDateTime;

public class Student {
	int rollno;
	LocalDateTime date_of_addmission, dob;
	int maths, physics, chemistry, English, hindi; 
	String classname;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public LocalDateTime getDate_of_addmission() {
		return date_of_addmission;
	}
	public void setDate_of_addmission(LocalDateTime date_of_addmission) {
		this.date_of_addmission = date_of_addmission;
	}
	public LocalDateTime getDob() {
		return dob;
	}
	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}
	public int getMaths() {
		return maths;
	}
	public void setMaths(int maths) {
		this.maths = maths;
	}
	public int getPhysics() {
		return physics;
	}
	public void setPhysics(int physics) {
		this.physics = physics;
	}
	public int getChemistry() {
		return chemistry;
	}
	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}
	public int getEnglish() {
		return English;
	}
	public void setEnglish(int english) {
		English = english;
	}
	public int getHindi() {
		return hindi;
	}
	public void setHindi(int hindi) {
		this.hindi = hindi;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public Student(int rollno, LocalDateTime date_of_addmission, LocalDateTime dob, int maths, int physics,
			int chemistry, int english, int hindi, String classname) {
		super();
		this.rollno = rollno;
		this.date_of_addmission = date_of_addmission;
		this.dob = dob;
		this.maths = maths;
		this.physics = physics;
		this.chemistry = chemistry;
		English = english;
		this.hindi = hindi;
		this.classname = classname;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", date_of_addmission=" + date_of_addmission + ", dob=" + dob + ", maths="
				+ maths + ", physics=" + physics + ", chemistry=" + chemistry + ", English=" + English + ", hindi="
				+ hindi + ", classname=" + classname + "]";
	}

	
}
