package com.yash.services;

import java.util.List;

import com.yash.entities.Doctor;
import com.yash.entities.Patient;

public interface DoctorService {
	public Doctor getDoctor(int docId);
//	public List<Doctor> getAllDoctors();
	public Doctor addDoctor(Doctor doctor);
//	public String deleteDoctor(int docId);
//	public Doctor modifyDoctor(Doctor doctor);
}
