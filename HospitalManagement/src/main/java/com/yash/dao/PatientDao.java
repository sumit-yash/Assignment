package com.yash.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.entities.Patient;

@Repository
public interface PatientDao extends JpaRepository<Patient, Integer>{
	
	public Patient findByEmailAndPassword(String email,String password);

}
