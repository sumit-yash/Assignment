package com.yash.services;

import com.yash.entities.AppointmentBooking;

public interface AppointmentBookingService {
	
	public AppointmentBooking addBooking(AppointmentBooking booking);
	public AppointmentBooking getBooking(int bookingId);

}
