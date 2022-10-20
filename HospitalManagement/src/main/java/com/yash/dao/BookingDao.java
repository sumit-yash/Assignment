package com.yash.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.entities.AppointmentBooking;

public interface BookingDao extends JpaRepository<AppointmentBooking, Integer>{

}
