package com.yash.serviceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.SpecialityDao;
import com.yash.entities.Speciality;
import com.yash.services.SpecialityService;

@Service
public class SpecialityServiceImpl implements SpecialityService{

	@Autowired
	SpecialityDao specialityDao;
	
	@Override
	public Speciality addSpeciality(Speciality speciality) {
		Speciality addSpeciality=new Speciality();
		if(speciality!= null) {
			addSpeciality=speciality;
			specialityDao.save(addSpeciality);
		}
		return addSpeciality;
	}

	@Override
	public List<Speciality> getSpeciality(String specialityName) {
		 return specialityDao.findBySpecialityName(specialityName);
	}

}
