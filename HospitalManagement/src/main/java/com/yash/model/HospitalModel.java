package com.yash.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.yash.entities.RoomCategory;
import com.yash.entities.Speciality;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalModel {
	
	private String hospitalName;
	
	
	private Speciality[] specialityArr;
	
	
	private RoomCategory[] roomCategoryArr;
	
	
	
	
	
	
	

}
