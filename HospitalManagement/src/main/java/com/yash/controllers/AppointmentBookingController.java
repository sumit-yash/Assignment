package com.yash.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.entities.AppointmentBooking;
import com.yash.services.AppointmentBookingService;

@RestController
@CrossOrigin("*")
@RequestMapping("/booking")
public class AppointmentBookingController {
	
	@Autowired
	AppointmentBookingService abService;
	
	private static final Logger logger = LoggerFactory.getLogger(AppointmentBookingController.class);

	
	@PostMapping("/add")
	@Transactional
	public ResponseEntity addBooking(@RequestBody AppointmentBooking booking) {
		AppointmentBooking rpt=null;
		logger.info("booking @Controller="+booking);
		
		if(booking != null) {
			rpt = abService.addBooking(booking);
		}
		if(rpt != null) {
			return new ResponseEntity<AppointmentBooking>(rpt,HttpStatus.OK);
		}else {
			return new ResponseEntity<AppointmentBooking>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity getBooking(@PathVariable("id") int id) {
		AppointmentBooking booking=null;
			booking=abService.getBooking(id);
		if(booking != null) {
			return new ResponseEntity<AppointmentBooking>(booking,HttpStatus.OK);
		}else {
			return new ResponseEntity<AppointmentBooking>(HttpStatus.NOT_FOUND);
		}
	}

}
