package com.yash.services;

import java.util.List;

import com.yash.entities.Hospital;

public interface HospitalService {
	public Hospital addHospital(Hospital hospital);
	public List<Hospital> getAllHospital();

}
