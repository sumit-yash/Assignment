package com.yash.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.entities.Login;
import com.yash.entities.Patient;
import com.yash.services.PatientService;

@RestController
@CrossOrigin("*")
public class CommonController {
	@Autowired
	PatientService patientService;

	@PostMapping("/login")
	public ResponseEntity<Patient> getLoginPatient(@RequestBody Login login) {
		System.out.println("@controller email=" + login.getEmail() + " password= " + login.getPassword());
		Patient patients = patientService.getPatientByEmailAndPassword(login.getEmail(), login.getPassword());
		System.out.println("return= " + patients);
		if (patients != null) {
			return new ResponseEntity<Patient>(patients, HttpStatus.OK);
		} else {
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		}
	}

}
