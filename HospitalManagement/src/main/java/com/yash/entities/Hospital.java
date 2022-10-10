package com.yash.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hospital")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hospitalId;
	
	
	private String hospitalName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="speciality_id")
	private List<Speciality> specialityList;
	
	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="roomCategory_id")
	private List<RoomCategory> roomCategoryList;
	
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="doctor_id")
//	private List<Doctor> doctorList;



}
