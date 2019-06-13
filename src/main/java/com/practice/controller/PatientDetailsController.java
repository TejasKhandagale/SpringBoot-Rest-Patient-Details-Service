package com.practice.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.model.Patient;
import com.practice.service.PatientDetailsService;

@RestController
@RequestMapping("/healthcare")
public class PatientDetailsController {
	
	@Autowired
	private PatientDetailsService patientService;
	
	@RequestMapping(value = "/allpatients",method = RequestMethod.GET,produces = "application/json")
	public List<Patient> getAllPatientDetails()
	{
		return patientService.getAllPatientDetails();
	}
	
	@RequestMapping(value = "/patient/{id}",method = RequestMethod.GET,produces = "application/json", consumes = "application/json")
	public Patient getPatientDetails(@PathVariable int id)
	{
		return patientService.getPatientDetails(id);
	}
	
	@RequestMapping(value = "/patient/add",method = RequestMethod.POST,produces = "application/json", consumes = "application/json")
	public Patient setPatientDetails(@RequestBody Patient patient)
	{
		return patientService.setPatientDetails(patient);
	}
	
	@RequestMapping(value = "/allpatients/add",method = RequestMethod.POST,produces = "application/json", consumes = "application/json")
	public List<Patient> setAllPatientDetails(@RequestBody List<Patient> patients)
	{
		return patientService.setAllPatientDetails(patients);
	}
	
	@RequestMapping(value = "/patient/search",method = RequestMethod.POST,produces = "application/json", consumes = "application/json")
	public List<Patient> searchPatientDetails(@RequestBody Map<String,String> searchKeyMap)
	{
		List<Patient> patientsList = new ArrayList<>();
		try {
			
			if(searchKeyMap != null && !searchKeyMap.isEmpty())
			{
				searchKeyMap.forEach((searchKey,val) -> {
					
					switch(searchKey.trim().toUpperCase())
					{
					case "PID":
						int pid = Integer.parseInt(val.trim());
						patientsList.addAll(patientService.searchPatient(pid));
						break;
						
					case "NAME":
						patientsList.addAll(patientService.searchPatient(val));
						break;
						
					case "AID":
						int aid = Integer.parseInt(val.trim());
						patientsList.addAll(patientService.searchPatientByAddress(aid));
						break;
						
					case "STREET":
						patientsList.addAll(patientService.searchPatientByAddress(val));
						break;	
						
					case "APPID":
						int appId = Integer.parseInt(val.trim());
						patientsList.addAll(patientService.searchPatientByAppointment(appId));
						break;
						
					case "CONTACT":
						patientsList.addAll(patientService.searchPatientByAppointment(val));
						break;
					}
					
				});
				
				//Set<Patient> uniquePatients = new LinkedHashSet<>(patientsList);
				//patientsList.clear();
				//patientsList.addAll(uniquePatients);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return patientsList.stream().distinct().collect(Collectors.toList());
	}
	
}
