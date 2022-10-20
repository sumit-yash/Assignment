package com.yash.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.entities.Doctor;
import com.yash.services.DoctorService;

@RestController
@RequestMapping("/doctor")
@CrossOrigin("*")
public class DoctorController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);

	
	@Autowired
	DoctorService docService;
	
	@PostMapping("/add")
	public ResponseEntity addDoctor(@RequestBody Doctor doctor) {
		Doctor addDoctor = docService.addDoctor(doctor);
		if(addDoctor!= null) {
			return new ResponseEntity<Doctor>(addDoctor,HttpStatus.OK);
		}else {
			return new ResponseEntity<Doctor>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity getDoctor(@PathVariable("id") int id) {
		Doctor fetchedDoctor = docService.getDoctor(id);
		if(fetchedDoctor!= null) {
			return new ResponseEntity<Doctor>(fetchedDoctor,HttpStatus.OK);
		}else {
			return new ResponseEntity<Doctor>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
}
