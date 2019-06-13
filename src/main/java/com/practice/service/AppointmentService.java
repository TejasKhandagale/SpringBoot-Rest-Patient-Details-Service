package com.practice.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.practice.dao.AppointmentRepository;
import com.practice.model.Appointment;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository appRepository;
	
	public Appointment scheduleAppointment(Appointment appointment)
	{
		if(appointment.getAppDate() == null)
			appointment.setAppDate(new Date());
		return appRepository.save(appointment);
		
	}

}
