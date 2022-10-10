package com.yash.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.entities.Doctor;
import com.yash.entities.Hospital;
import com.yash.entities.RoomCategory;
import com.yash.entities.Speciality;
import com.yash.services.DoctorService;
import com.yash.services.HospitalService;
import com.yash.services.RoomCategoryService;
import com.yash.services.SpecialityService;

@RestController
@RequestMapping("/speciality")
public class SpecialityController {

	@Autowired
	SpecialityService specialityService;

	@GetMapping("/getSpeciality/{speciality}")
	public List<Speciality> getSpeciality(@PathVariable("speciality") String specialityName) {
		List<Speciality> speciality = specialityService.getSpeciality(specialityName);
		for (Speciality sp : speciality) {
//			int date = sp.getStartDate().getDate();
//			int month=sp.getStartDate().getMonth();
//			int year=sp.getStartDate().getYear();
//			sp.setStartDate(new Date(year, month, date));
//			int edate = sp.getEndDate().getDate();
//			int emonth=sp.getEndDate().getMonth();
//			int eyear=sp.getEndDate().getYear();
//			sp.setEndDate(new Date(eyear, emonth, edate));
			System.out.println("sp="+sp);
		}
		
		return speciality;
	}

	@PostMapping("/addSpeciality")
	public Speciality addSpeciality(@RequestBody Speciality speciality) {
		Speciality addSpeciality = specialityService.addSpeciality(speciality);
		return addSpeciality;
	}

}
