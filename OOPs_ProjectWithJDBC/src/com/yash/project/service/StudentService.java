package com.yash.project.service;

import java.util.List;

import com.yash.project.entity.Student;

public interface StudentService {
	public int addStudent(Student stu);
	public Student modifyStudent(Student stu);
	public int removeStudent(int studId);
	public Student getStudent(int studId);
	public List<Student> getAllStudents();
}
