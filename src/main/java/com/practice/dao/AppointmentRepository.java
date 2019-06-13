package com.practice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.Appointment;
@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

}
