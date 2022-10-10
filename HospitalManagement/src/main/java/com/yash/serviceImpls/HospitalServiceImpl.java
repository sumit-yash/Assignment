package com.yash.serviceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.HospitalDao;
import com.yash.entities.Hospital;
import com.yash.services.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService{
	
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
		// TODO Auto-generated method stub
		return hospitalDao.findAll();
	}
	

}
