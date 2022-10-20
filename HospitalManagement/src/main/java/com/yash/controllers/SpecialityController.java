package com.yash.controllers;

import java.util.List;

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

import com.yash.entities.Speciality;
import com.yash.services.SpecialityService;

@RestController
@CrossOrigin("*")
@RequestMapping("/speciality")
public class SpecialityController {
	
	private static final Logger logger = LoggerFactory.getLogger(SpecialityController.class);


	@Autowired
	SpecialityService specialityService;

	@GetMapping("/{speciality}")
	public ResponseEntity getSpeciality(@PathVariable("speciality") String specialityName) {
		logger.info("request specialityName= "+specialityName);
		Speciality speciality =null;
		for (Speciality ls : specialityService.getSpeciality(specialityName)) {
			speciality=ls;
		} 
		if(speciality!= null) {
			return new ResponseEntity<Speciality>(speciality,HttpStatus.OK);
		}else {
			return new ResponseEntity<Speciality>(HttpStatus.NOT_FOUND);
		}
		
	}

	@PostMapping("/addSpeciality")
	public ResponseEntity addSpeciality(@RequestBody Speciality speciality) {
		Speciality addSpeciality = specialityService.addSpeciality(speciality);
		if(addSpeciality!= null) {
			return new ResponseEntity<Speciality>(addSpeciality,HttpStatus.OK);
		}else {
			return new ResponseEntity<Speciality>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity getAllSpeciality(){
		if(specialityService.getAllSpecialities()!= null) {
			return new ResponseEntity<List<Speciality>>(specialityService.getAllSpecialities(),HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Speciality>>(HttpStatus.NOT_FOUND);
		}
		
	}

}
