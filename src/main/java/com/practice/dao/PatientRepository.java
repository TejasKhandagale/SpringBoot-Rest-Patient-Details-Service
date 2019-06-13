package com.practice.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {
	
	public List<Patient> findByPid(int pid);
	public List<Patient> findByName(String name);
	public List<Patient> findByAddressAid(int aid);
	public List<Patient> findByAddressStreet(String street);
	public List<Patient> findByAppointmentAppId(int appId);
	public List<Patient> findByAppointmentContact(String contact);
}
