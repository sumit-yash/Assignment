package com.yash.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.entities.Doctor;

@Repository
public interface DoctorDao extends JpaRepository<Doctor, Integer>{
	
}
