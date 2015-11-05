package com.pwr.tombKeeper.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Grave implements Serializable{

	private static final long serialVersionUID = -8332624711297311413L;

	
	private String firstname;

	private String lastname;
	
	private double lattitude;
	
	private double longtitude;

	
	public double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getLattitude() {
		return lattitude;
	}

	public void setLattitude(double d) {
		this.lattitude = d;
	}
	
}
