package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.google.gson.Gson;
import com.practice.model.Appointment;
import com.practice.service.AppointmentService;

@RestController
@RequestMapping("/healthcare")
public class PatientAppointmentController {
	
	//Gson gson = new Gson();
	@Autowired
	private AppointmentService appService;

	@RequestMapping(path = "/appointment", method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
	public Appointment getAppoinmentDetails(@RequestBody Appointment appointment)
	{
		//String response = "";
		if(appointment != null && !StringUtils.isEmpty(appointment.contact) && !StringUtils.isEmpty(appointment.name))
			appService.scheduleAppointment(appointment);
		else
			appointment = null;
		
		return appointment;
	}
	
}
