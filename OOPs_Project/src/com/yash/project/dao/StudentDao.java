package com.yash.project.dao;

import java.util.List;

import com.yash.project.entity.Student;

public interface StudentDao {
	public int addStudent(Student stu);
	public Student updateStudent(Student stu);
	public int deleteStudent(int studId);
	public Student getStudent(int studId);
	public List<Student> getAllStudents();
}
