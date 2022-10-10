package com.yash.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.entities.Hospital;
import com.yash.services.HospitalService;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
	
	@Autowired
	HospitalService hospitalService;
	
	@PostMapping("/add")
	public Hospital addHospital(@RequestBody Hospital hospital) {
		Hospital addHospital = hospitalService.addHospital(hospital);
		return addHospital;
	}
	
	@GetMapping("/getAll")
	public List<Hospital> getAllHospital() {
		return hospitalService.getAllHospital();
	}
}
