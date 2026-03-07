package com.ak.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.TableGenerator;

@Entity
public class Batch {
	/// this is done by hibernate.
	@Id
	@TableGenerator(allocationSize = 1, initialValue = 101, table = "allidgenerator", valueColumnName = "nextbatchid", name = "batchidgenerator")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "batchidgenerator")
	long bid;

	String name;

	Date startDate;

	public long getBid() {
		return bid;
	}

	public void setBid(long bid) {
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public List<Trainer> getTrainers() {
		return trainers;
	}

	public void setTrainers(List<Trainer> trainers) {
		this.trainers = trainers;
	}

	Date endDate;

	String venue;

	@ManyToMany
	@JoinTable(name = "TopicTeaching", joinColumns = { @JoinColumn(name = "bid") }, inverseJoinColumns = {
			@JoinColumn(name = "trainerid") }) // We used joinColumn here because we wanted to name the third table
												// something
	List<Trainer> trainers = new ArrayList<>();

}
