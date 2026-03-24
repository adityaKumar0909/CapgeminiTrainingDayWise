package com.ak.mockitodemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    Date startDate;
    Date endDate;
    String topic;
    String trainername;

    public Training() {

    }

    public Training(int id, Date startDate, Date endDate, String topic, String trainername) {
        super();
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.topic = topic;
        this.trainername = trainername;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTrainername() {
        return trainername;
    }

    public void setTrainername(String trainername) {
        this.trainername = trainername;
    }
}
