package com.ak.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Trainee {
	/// this is done by DBMS
	@SequenceGenerator(name = "traineeseq", allocationSize = 1, initialValue = 1001, sequenceName = "traineeseq")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "traineeseq")
	long superId;
	@Column(nullable = false)
	String name;

	String insitute;

	String email;

	String phoneNo;
	@ManyToOne
	Batch batch;

	public long getSuperId() {
		return superId;
	}

	public void setSuperId(long superId) {
		this.superId = superId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInsitute() {
		return insitute;
	}

	public void setInsitute(String insitute) {
		this.insitute = insitute;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

}
