package com.gal.issueTracker.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String issue_type;
    String issue_description;
    Date issue_date;
    boolean isResolved;


    @ManyToOne
    @JoinColumn(name="employee_id", nullable=false)
    Employee employee;

    public Issue(){}

    public boolean isResolved() {
        return isResolved;
    }

    public void setResolved(boolean resolved) {
        isResolved = resolved;
    }

    public Issue(int issue_id, String issue_type, String issue_description, Date issue_date, Employee employee , boolean isResolved) {
        this.id = issue_id;
        this.issue_type = issue_type;
        this.issue_description = issue_description;
        this.issue_date = issue_date;
        this.employee = employee;
        this.isResolved = isResolved;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIssue_type() {
        return issue_type;
    }

    public void setIssue_type(String issue_type) {
        this.issue_type = issue_type;
    }

    public String getIssue_description() {
        return issue_description;
    }

    public void setIssue_description(String issue_description) {
        this.issue_description = issue_description;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
