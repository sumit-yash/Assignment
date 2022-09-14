package com.yash.project.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.yash.project.entity.Student;

public class StudentDaoImpl implements StudentDao{
	
	
	//static list of student
	private static List<Student> stuList=new ArrayList<>(Arrays.asList(
				new Student(1, "sumit", "wardha"),
				new Student(2, "vijay", "akola"),
				new Student(3, "ajat", "nagpur"),
				new Student(4, "pankaj", "amaravti")));
	

	@Override
	public int addStudent(Student stu) {
		stuList.add(stu);
//		System.out.println("Student Added entity= "+stuList);
		return stu.getRollNo();
	}

	@Override
	public Student updateStudent(Student stu) {
		Student student = getStudent(stu.getRollNo());
		if(student!= null) {
			student.setAddress(stu.getAddress());
			student.setName(stu.getName());
			student.setRollNo(stu.getRollNo());
		}
		return student;
	}

	@Override
	public int deleteStudent(int studId) {
		Student student = getStudent(studId);
		System.out.println("Deleted Entry= "+student);
		boolean remove = this.stuList.remove(student);
		System.out.println("boolean remove="+remove);
		return studId;
	}

	@Override
	public Student getStudent(int studId) {
		Student st=null;
		for (Student student : stuList) {
			if(student.getRollNo()==studId) {
				st=new Student();
				st=student;
			}
		}
		return st;
	}

	@Override
	public List<Student> getAllStudents() {
		return this.stuList;
	}

}
