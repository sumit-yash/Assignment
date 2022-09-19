package com.yash.sm.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.sm.entity.Student;
import com.yash.sm.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;

	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student){
		Student addStudent = studentService.addStudent(student);
		return addStudent;
	}
	
	@PutMapping("/student/{stuId}")
	public Student modifyStudent(@RequestBody Student stu) {
		Student modifyStudent = studentService.modifyStudent(stu);
		return modifyStudent; 
	}

	@DeleteMapping("/student/{deleteId}")
	public String removeStudent(@PathVariable ("deleteId")  int deleteId) {
		String removeStudent = studentService.removeStudent(deleteId);
		return removeStudent;
	}
	
	@GetMapping("/student/{stuId}")
	public Student getStudent(@PathVariable("stuId") int stuId) {
		Student student = studentService.getStudent(stuId);
		return student;
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		List<Student> allStudents = studentService.getAllStudents();
		return allStudents;
	}
}
