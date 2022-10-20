package com.yash.controllers;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.entities.Patient;
import com.yash.services.PatientService;

@RestController
@CrossOrigin("*")
@RequestMapping("/patient")
public class PatientController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

	
	@Autowired
	PatientService patientService;
	
	@GetMapping("/{id}")
	public ResponseEntity getPatient(@PathVariable("id") int patientId) {
		Patient patient = patientService.getPatient(patientId);
		if(patient!= null) {
			return new ResponseEntity<Patient>(patient,HttpStatus.OK);
		}else {
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity getAllPatients(){
		List<Patient> allPatients = patientService.getAllPatients();
		if(allPatients!= null) {
			return new ResponseEntity<List<Patient>>(allPatients,HttpStatus.OK);
		}else {
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity addPatient(@RequestBody Patient patient) {
		Patient addPatient = patientService.addPatient(patient);
		if(addPatient!= null) {
			return new ResponseEntity<Patient>(addPatient,HttpStatus.OK);
		}else {
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deletePatient(@PathVariable("id") int patientId) {
		String deletePatient = patientService.deletePatient(patientId);
		logger.info("deletePatient="+deletePatient);
		if(deletePatient.contains("Patient Deleted Successfully")) {
			return new ResponseEntity(deletePatient,HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity modifyPatient(@RequestBody Patient patient) {
		Patient modifyPatient = patientService.modifyPatient(patient);
		if(modifyPatient!= null) {
			return new ResponseEntity<Patient>(modifyPatient,HttpStatus.OK);
		}else {
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		}
	}

}
