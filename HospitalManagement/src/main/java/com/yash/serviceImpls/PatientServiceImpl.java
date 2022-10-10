package com.yash.serviceImpls;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.PatientDao;
import com.yash.entities.Patient;
import com.yash.exceptions.Exceptions;
import com.yash.services.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientDao patientDao;

	@Override
	public Patient getPatient(int patientId) {
		Patient patient = null;
		try {
			Optional<Patient> patientOptional = patientDao.findById(patientId);
			patient = convertToPatient(patientOptional);
		} catch (Exception e) {
			System.out.println("Error while getting patient");
		}
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
			System.out.println("Error while gettingAllpatient");
		}
		return patientList;
	}

	@Override
	public Patient addPatient(Patient patient) {
		Patient addedPatient = null;
		Patient exisitngPatient = null;
		System.out.println("patient=" + patient);
		exisitngPatient = getPatientByEmailAndPassword(patient.getEmail(),patient.getPassword());
		System.out.println("exisiting=" + exisitngPatient);
		try {
			if (patient != null && exisitngPatient==null) {
				addedPatient = patientDao.save(patient);
			}else {
				throw new Exception("");
			}
		} catch (Exception e) {
			System.out.println("Error while adding patient");
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
			System.out.println("Error while deleting patient");
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
			System.out.println("Error while modifing patient");
		}
		return modifiedPatient;
	}

	@Override
	public Patient getPatientByEmailAndPassword(String email, String password) {
		 Patient patients = null;
		try {
			System.out.println("@service email=" + email + " password=" + password);
			patients = patientDao.findByEmailAndPassword(email, password);
			System.out.println("@service patient=" + patients);
		} catch (Exception e) {
			System.out.println("error while getting patient by email and password");
		}
		return patients;
	}

}
