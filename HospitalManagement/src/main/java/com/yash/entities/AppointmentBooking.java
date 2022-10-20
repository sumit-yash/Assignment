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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Appointment_Booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointmentBookingId;
//	private String receiptName;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="pid")
	private Patient patient;
	
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="hospital_id")
	private Hospital hospital;
	
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy'T'HH:mm:ss[.SSS][.SS][.S]")
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
//	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	private Date startDate;
	
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy'T'HH:mm:ss[.SSS][.SS][.S]")
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
//	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="MM/dd/yyyy")
	private Date endDate;

}
