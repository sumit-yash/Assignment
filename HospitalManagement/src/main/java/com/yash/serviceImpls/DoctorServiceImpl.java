package com.yash.serviceImpls;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.DoctorDao;
import com.yash.dao.PatientDao;
import com.yash.entities.Doctor;
import com.yash.services.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{

	
	private static final Logger logger = LoggerFactory.getLogger(DoctorServiceImpl.class);

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

	@Override
	public Doctor getDoctor(int docId) {
		Doctor doc=null;
		try {
			doc = doctorDao.findById(docId).get();
		}catch(Exception e) {
			logger.error("exception while getting doctor");
		}
		return doc;
	}
	

}
