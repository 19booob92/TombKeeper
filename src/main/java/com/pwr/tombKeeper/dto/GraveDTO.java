package com.pwr.tombKeeper.dto;

import java.util.List;

import com.pwr.tombKeeper.model.Human;

public class GraveDTO {

	private String id;
	
	private String firstname;

	private String lastname;
	
	private String lattitude;
	
	private String longtitude;
	
	private List<Human> owners;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getLattitude() {
		return lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	public String getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}

	public List<Human> getOwners() {
		return owners;
	}

	public void setOwners(List<Human> owners) {
		this.owners = owners;
	}

	
}
