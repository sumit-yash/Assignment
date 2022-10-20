package com.yash.serviceImpls;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.BookingDao;
import com.yash.dao.PatientDao;
import com.yash.dao.ReceiptDao;
import com.yash.entities.Patient;
import com.yash.entities.AppointmentBooking;
import com.yash.services.PatientService;
import com.yash.services.AppointmentBookingService;

@Service
public class AppointmentBookingServiceImpl implements AppointmentBookingService {
	
	
	private static final Logger logger = LoggerFactory.getLogger(AppointmentBookingServiceImpl.class);

	@Autowired
	BookingDao bookingDao;

	@Autowired
	PatientService patientService;
	
	@Autowired
	HospitalServiceImpl hospitalService;

	@Override
	public AppointmentBooking addBooking(AppointmentBooking booking) {
		logger.info("booking at serviceImpl=" + booking);
		AppointmentBooking bookingadd = null;
		try {
			if (booking != null) {
				String email = booking.getPatient().getEmail();
				String password = booking.getPatient().getPassword();
				logger.info("bedCount="+booking.getHospital().getBedCount());
				
//				int count=booking.getHospital().getBedCount();
//				booking.getHospital().setBedCount(count-1);
//				logger.info("updated bedCount="+booking.getHospital().getBedCount());
				Patient patient = patientService.getPatientByEmailAndPassword(email, password);
				if (patient != null) {
					hospitalService.addHospital(booking.getHospital());
					bookingadd = bookingDao.save(booking);
				} else {
					throw new Exception("invalid patient");
				}
			}
		} catch (Exception e) {
			logger.error("Error while adding receipt: " + e);
		}
		return bookingadd;
	}

	@Override
	public AppointmentBooking getBooking(int bookingId) {
		AppointmentBooking booking = null;
		try {
			booking = bookingDao.findById(bookingId).get();
			logger.info("receipt=" + booking);
		} catch (Exception e) {
			logger.error("Error while getting booking: " + e);
		}
		return booking;
	}

}
