package com.yash.serviceImpls;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.PatientDao;
import com.yash.entities.Patient;
import com.yash.services.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	
	
	private static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);


	@Autowired
	PatientDao patientDao;

	@Override
	public Patient getPatient(int patientId) {
		Patient patient = null;
		try {
			 patient = patientDao.findById(patientId).get();
//			patient = patientOptional.get();
			System.out.println("try patient="+patient);
		} catch (Exception e) {
			logger.error("Error while getting patient");
		}
		logger.info("patient="+patient);
		return patient;
	}

	private Patient convertToPatient(Optional<Patient> patientOptional) {
		Patient patient = null;
		if (patientOptional != null && !patientOptional.isEmpty()) {
			patient.setPid(patientOptional.get().getPid());
			patient.setFname(patientOptional.get().getFname());
			patient.setMname(patientOptional.get().getMname());
			patient.setLname(patientOptional.get().getLname());
			patient.setEmail(patientOptional.get().getEmail());
			patient.setPassword(patientOptional.get().getPassword());
		}
		return patient;
	}

	@Override
	public List<Patient> getAllPatients() {
		List<Patient> patientList = new ArrayList<>();
		try {
			patientList = patientDao.findAll();
		} catch (Exception e) {
			logger.error("Error while gettingAllpatient");
		}
		return patientList;
	}

	@Override
	public Patient addPatient(Patient patient) {
		Patient addedPatient = null;
		Patient exisitngPatient = null;
		logger.info("patient=" + patient);
		exisitngPatient = getPatientByEmailAndPassword(patient.getEmail(),patient.getPassword());
		logger.info("exisiting=" + exisitngPatient);
		try {
			if (patient != null && exisitngPatient==null) {
				addedPatient = patientDao.save(patient);
			}else {
				throw new Exception("");
			}
		} catch (Exception e) {
			logger.error("Error while adding patient");
		}
		return addedPatient;
	}

	@Override
	public String deletePatient(int patientId) {
		String message = "Error while deleting patient";
		try {
			Patient patient = getPatient(patientId);
			if (patient != null) {
				patientDao.delete(patient);
				message = "Patient Deleted Successfully";
			}
		} catch (Exception e) {
			logger.error("Error while deleting patient");
		}
		return message;
	}

	@Override
	public Patient modifyPatient(Patient patient) {
		Patient modifiedPatient = new Patient();
		try {
			if (patient != null) {
				modifiedPatient = getPatient(patient.getPid());
				if (modifiedPatient != null) {
					modifiedPatient.setFname(patient.getFname());
					modifiedPatient.setMname(patient.getMname());
					modifiedPatient.setLname(patient.getLname());
					modifiedPatient.setEmail(patient.getEmail());
					modifiedPatient.setPassword(patient.getPassword());
					modifiedPatient = patientDao.save(modifiedPatient);
				}
			}
		} catch (Exception e) {
			logger.error("Error while modifing patient");
		}
		return modifiedPatient;
	}

	@Override
	public Patient getPatientByEmailAndPassword(String email, String password) {
		 Patient patients = null;
		try {
			logger.info("@service email=" + email + " password=" + password);
			patients = patientDao.findByEmailAndPassword(email, password);
			logger.info("@service patient=" + patients);
		} catch (Exception e) {
			logger.error("error while getting patient by email and password");
		}
		return patients;
	}

}
