package com.practice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.PatientRepository;
import com.practice.model.Patient;

@Service
public class PatientDetailsService {

	@Autowired
	private PatientRepository patRepository;
	
	public List<Patient> getAllPatientDetails()
	{
		List<Patient> patients = new ArrayList<>();
		patRepository.findAll().forEach(patients::add);
		return patients;
	}
	
	public Patient getPatientDetails(int id)
	{
		return patRepository.findById(id).get();
	}

	public Patient setPatientDetails(Patient patient) {
		// TODO Auto-generated method stub
		return patRepository.save(patient);
	}

	public List<Patient> setAllPatientDetails(List<Patient> patients) {
		// TODO Auto-generated method stub
		List<Patient> result = new ArrayList<>();
		patRepository.saveAll(patients).forEach(result::add);
		return result;
	}

	public List<Patient> searchPatient(int pid) {
		// TODO Auto-generated method stub
		return patRepository.findByPid(pid);
	}
	
	public List<Patient> searchPatient(String name) {
		// TODO Auto-generated method stub
		return patRepository.findByName(name);
	}
	
	public List<Patient> searchPatientByAddress(int aid) {
		// TODO Auto-generated method stub
		return patRepository.findByAddressAid(aid);
	}
	
	public List<Patient> searchPatientByAddress(String street) {
		// TODO Auto-generated method stub
		return patRepository.findByAddressStreet(street);
	}
	
	public List<Patient> searchPatientByAppointment(int appId) {
		// TODO Auto-generated method stub
		return patRepository.findByAppointmentAppId(appId);
	}
	
	public List<Patient> searchPatientByAppointment(String contact) {
		// TODO Auto-generated method stub
		return patRepository.findByAppointmentContact(contact);
	}
}
