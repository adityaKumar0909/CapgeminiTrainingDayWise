package com.ak.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Trainer {
	// this is done by DBMS itself
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long trainerid;

	@Column(unique = true)
	long capgtrainerid;
	@Column(nullable = false)
	String name;
	String company;
	String specialization;

	public long getTrainerid() {
		return trainerid;
	}

	public void setTrainerid(long trainerid) {
		this.trainerid = trainerid;
	}

	public long getCapgtrainerid() {
		return capgtrainerid;
	}

	public void setCapgtrainerid(long capgtrainerid) {
		this.capgtrainerid = capgtrainerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

}
