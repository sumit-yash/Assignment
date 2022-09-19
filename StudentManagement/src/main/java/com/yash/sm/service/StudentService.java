package com.yash.sm.service;

import java.util.List;
import java.util.Optional;

import com.yash.sm.entity.Student;

public interface StudentService {
	
	public Student addStudent(Student stu);
	public Student modifyStudent(Student stu);
	public String removeStudent(int studId);
	public Student getStudent(int studId);
	public List<Student> getAllStudents(); 

}
