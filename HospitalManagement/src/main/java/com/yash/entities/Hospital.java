package com.yash.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	private String address;
	private Integer bedCount;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="speciality_id")
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cat_id")
	private RoomCategory roomCategory;
	
	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="speciality_id")
	private Speciality speciality;
	
	
	

	
	
	
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="roomCategory_id")
	
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="doctor_id")
//	private List<Doctor> doctorList;



}
