package com.yash.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.entities.Hospital;

@Repository
public interface HospitalDao extends JpaRepository<Hospital, Integer>{
	
	public List<Hospital> findByAddress(String address);

}
