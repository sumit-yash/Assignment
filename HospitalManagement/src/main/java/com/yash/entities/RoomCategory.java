package com.yash.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "room_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catId;

	private String catName;
	private Integer catRate;

	
	
	

//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
//	private LocalDate startDate;
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
//	private LocalDate endDate;

//	@ManyToMany(cascade = CascadeType.ALL)
//	private List<Hospital> hospitalList;

}
