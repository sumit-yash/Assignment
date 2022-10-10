package com.yash.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.entities.Hospital;
import com.yash.entities.Patient;

@Repository
public interface HospitalDao extends JpaRepository<Hospital, Integer>{

}
