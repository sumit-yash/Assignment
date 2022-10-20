package com.yash.services;

import java.util.List;

import com.yash.entities.Hospital;

public interface HospitalService {
	public Hospital addHospital(Hospital hospital);
	public Hospital getHospital(Integer hospitalId);
	public List<Hospital> getHospitalByAddress(String hospitalAddress);
	public List<Hospital> getAllHospital();

}
