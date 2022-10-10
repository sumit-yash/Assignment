package com.yash.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	PatientService patientService;
	
	@GetMapping("/{id}")
	public Patient getPatient(@PathVariable("id") int patientId) {
		Patient patient = patientService.getPatient(patientId);
		return patient; 
	}
	
	@GetMapping("/all")
	public List<Patient> getAllPatients(){
		List<Patient> allPatients = patientService.getAllPatients();
		return allPatients;
	}
	
	@PostMapping("/add")
	public Patient addPatient(@RequestBody Patient patient) {
		Patient addPatient = patientService.addPatient(patient);
		return addPatient;
	}
	
	@DeleteMapping("/{id}")
	public String deletePatient(@PathVariable("id") int patientId) {
		String deletePatient = patientService.deletePatient(patientId);
		return deletePatient;
		
	}
	
	@PutMapping("/{id}")
	public Patient modifyPatient(@RequestBody Patient patient) {
		Patient modifyPatient = patientService.modifyPatient(patient);
		return modifyPatient;
	}

}
