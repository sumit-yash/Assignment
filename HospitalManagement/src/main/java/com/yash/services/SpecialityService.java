package com.yash.services;

import java.util.List;

import com.yash.entities.Speciality;

public interface SpecialityService {
	public Speciality addSpeciality(Speciality speciality);
	public List<Speciality> getSpeciality(String specialityName);
	public List<Speciality> getAllSpecialities();
}
