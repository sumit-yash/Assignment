package com.yash.serviceImpls;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.HospitalDao;
import com.yash.entities.Hospital;
import com.yash.services.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService{
	
	
	private static final Logger logger = LoggerFactory.getLogger(HospitalServiceImpl.class);

	
	@Autowired
	HospitalDao hospitalDao;

	@Override
	public Hospital addHospital(Hospital hospital) {
		Hospital addHospital=new Hospital();
		if(hospital!= null) {
			addHospital=hospital;
			addHospital=hospitalDao.save(addHospital);
		}
		return addHospital;
	}

	@Override
	public List<Hospital> getAllHospital() {
		return hospitalDao.findAll();
	}

	@Override
	public Hospital getHospital(Integer hospitalId) {
		Hospital hospital=null;
		if(hospitalDao.findById(hospitalId).get()!= null) {
			hospital=hospitalDao.findById(hospitalId).get();
		}
		return hospital;
	}

	@Override
	public List<Hospital> getHospitalByAddress(String hospitalAddress) {
		List<Hospital> hospitals=null;
		if(hospitalDao.findByAddress(hospitalAddress) != null ) {
			hospitals=hospitalDao.findByAddress(hospitalAddress);
		}
		return hospitals;
	}
	

}
