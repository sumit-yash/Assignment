package com.yash.sm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.sm.dao.StudentDao;
import com.yash.sm.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;

	@Override
	public Student addStudent(Student stu) {
		Student st = new Student();
		if (stu != null) {
			try {
				st = studentDao.save(stu);
			} catch (Exception e) {
				System.out.println("Exception while adding student");
			}
		}
		return st;
	}

	@Override
	public Student modifyStudent(Student stu) {
		Student student = new Student();
		try {
			student = getStudent(stu.getRollNo());
			if (student != null) {
				student.setName(stu.getName());
				student.setAddress(stu.getAddress());
				student = studentDao.save(student);
			}
		} catch (Exception e) {
			System.out.println("Exception while modifing student");
		}
		return student;
	}

	@Override
	public String removeStudent(int removeId) {
		boolean flag = false;
		try {
			Student student = getStudent(removeId);
			if (student != null) {
				studentDao.delete(student);
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("Exception while removing student");
		}
		if (flag) {
			return "Student removed Successfully";
		} else {
			return "Unable to remove student";
		}
	}

	@Override
	public Student getStudent(int rollNo) {
		Optional<Student> stud = studentDao.findById(rollNo);
		Student st = changetoStudent(stud);
		return st;
	}

	private Student changetoStudent(Optional<Student> student) {
		Student st = new Student();
		if (student != null) {
			st.setRollNo(student.get().getRollNo());
			st.setName(student.get().getName());
			st.setAddress(student.get().getAddress());
		}
		return st;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> studentList = new ArrayList<>();
		try {
			studentList = studentDao.findAll();
		} catch (Exception e) {
			System.out.println("Exception while fetching all students");
		}
		return studentList;
	}

}
