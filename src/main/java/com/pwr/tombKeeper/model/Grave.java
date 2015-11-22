package com.pwr.tombKeeper.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Grave implements Serializable{

	private static final long serialVersionUID = -8332624711297311413L;

	private String firstname;

	private String lastname;
	
	private Double lattitude;
	
	private Double longtitude;
	
	private List<Human> owners;

	
	public List<Human> getOwners() {
		return owners;
	}

	public void setOwnres(List<Human> owners) {
		this.owners = owners;
	}

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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((owners == null) ? 0 : owners.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((lattitude == null) ? 0 : lattitude.hashCode());
		result = prime * result + ((longtitude == null) ? 0 : longtitude.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		Grave toCompare = (Grave) o;
		return this.getFirstname().equals(toCompare.getFirstname())
				&& this.getLastname().equals(toCompare.getLastname());
	}
	
}
