package com.yash.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Speciality")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Speciality {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int specialityId;
	
	private String specialityName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="doctor_id")
	private Doctor doctor;
	
	
//	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "specialityList")
//	private List<Hospital> hospitalList;

	
}
