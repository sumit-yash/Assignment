package com.yash.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.DoctorDao;
import com.yash.dao.PatientDao;
import com.yash.entities.Doctor;
import com.yash.services.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	DoctorDao doctorDao;
	
	@Override
	public Doctor addDoctor(Doctor doctor) {
		Doctor addDoctor=new Doctor();
		if(doctor!= null) {
			addDoctor=doctorDao.save(doctor);
		}
		return addDoctor;
	}
	

}
