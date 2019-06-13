package com.practice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PATIENT_DTLS")
public class Patient {
	
	@Id
	@Column(name = "PID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int pid;
	
	public String name;
	public int age;
	public String weight;
	@OneToOne(cascade = CascadeType.ALL)
	//@JoinTable(name = "PATIENT_ADD_MAPPING", inverseJoinColumns = "ADDRS_ID", joinColumns = "PID")
	@JoinColumn(name = "ADDRS_ID")
	public Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "BILL_ID")
	public BillDetails billDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "APP_ID")
	public Appointment appointment;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public BillDetails getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(BillDetails billDetails) {
		this.billDetails = billDetails;
	}
	
}