package com.yash.sm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.sm.entity.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{

}
