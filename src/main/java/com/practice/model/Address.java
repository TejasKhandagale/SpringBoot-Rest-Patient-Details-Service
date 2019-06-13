package com.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address {
	
	@Id
	@Column(name = "ADDRS_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int aid;
	
	public String street;
	public String city;
	public String _state;
	public int pin;
	public String _type;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return _state;
	}

	public void setState(String _state) {
		this._state = _state;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getType() {
		return _type;
	}

	public void setType(String _type) {
		this._type = _type;
	}

}
