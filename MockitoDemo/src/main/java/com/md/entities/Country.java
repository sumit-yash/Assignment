package com.md.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer countryId;
	private String countryName;
	private String capitalName;

}
