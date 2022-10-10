package com.yash.services;

import java.util.List;

import com.yash.entities.Patient;

public interface PatientService {
	
	public Patient getPatient(int patientId);
	public List<Patient> getAllPatients();
	public Patient addPatient(Patient patient);
	public String deletePatient(int patientId);
	public Patient modifyPatient(Patient patient);
	public Patient getPatientByEmailAndPassword(String email,String passsowrd);

}
