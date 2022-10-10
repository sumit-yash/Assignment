package com.yash.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.entities.Speciality;

@Repository
public interface SpecialityDao extends JpaRepository<Speciality, Integer>{
	List<Speciality> findBySpecialityName(String specialityName);
}
