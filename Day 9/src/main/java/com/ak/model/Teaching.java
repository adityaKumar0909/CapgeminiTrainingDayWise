package com.ak.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Teaching {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	long teachingid;
	@ManyToOne
	@JoinColumn(name = "trainerid", nullable = false)
	Trainer trainer;

	@ManyToOne
	@JoinColumn(name = "bid", nullable = false)
	Batch batch;

	public long getTeachingid() {
		return teachingid;
	}

	public void setTeachingid(long teachingid) {
		this.teachingid = teachingid;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Date getStDate() {
		return stDate;
	}

	public void setStDate(Date stDate) {
		this.stDate = stDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getTopics() {
		return topics;
	}

	public void setTopics(String topics) {
		this.topics = topics;
	}

	Date stDate;
	Date endDate;
	String topics;

}
