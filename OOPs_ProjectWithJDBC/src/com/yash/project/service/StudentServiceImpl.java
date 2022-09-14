package com.yash.project.service;

import java.util.List;

import com.yash.project.dao.StudentDao;
import com.yash.project.dao.StudentDaoImpl;
import com.yash.project.entity.Student;

public class StudentServiceImpl implements StudentService{

	StudentDao stuDao=new StudentDaoImpl();
	
	@Override
	public int addStudent(Student stu) {
		return stuDao.addStudent(stu);
	}

	@Override
	public Student modifyStudent(Student stu) {
		return stuDao.updateStudent(stu);
	}

	@Override
	public int removeStudent(int studId) {
		return stuDao.deleteStudent(studId);
	}

	@Override
	public Student getStudent(int studId) {
		return stuDao.getStudent(studId);
	}

	@Override
	public List<Student> getAllStudents() {
		return stuDao.getAllStudents();
	}

}
