package com.gal.issueTracker.service;

import com.gal.issueTracker.model.Employee;
import com.gal.issueTracker.model.Issue;

import java.util.List;

public interface IssueService {

    Issue findIssueById(int id);
    Issue addIssue(Issue issue);
    Issue updateIssue(Issue issue);
    void deleteIssueById(int id);
    List<Employee> findAllEmployeesWhoRaisedIssueByMonth(int month);
}
