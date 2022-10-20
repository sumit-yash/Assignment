package com.yash.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.entities.Login;
import com.yash.entities.Patient;
import com.yash.services.PatientService;

@RestController
@CrossOrigin("*")
public class CommonController {
	@Autowired
	PatientService patientService;
	
	private static final Logger loggger = LoggerFactory.getLogger(CommonController.class);


	@PostMapping("/login")
	public ResponseEntity getLoginPatient(@RequestBody Login login) {
		loggger.info("@controller email=" + login.getEmail() + " password= " + login.getPassword());
		Patient patients = patientService.getPatientByEmailAndPassword(login.getEmail(), login.getPassword());
		loggger.info("return= " + patients);
		if (patients != null) {
			return new ResponseEntity<Patient>(patients, HttpStatus.OK);
		} else {
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		}
	}

}
