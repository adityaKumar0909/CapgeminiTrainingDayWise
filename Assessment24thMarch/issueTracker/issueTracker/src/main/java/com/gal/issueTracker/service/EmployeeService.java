package com.gal.issueTracker.service;

import com.gal.issueTracker.model.Employee;
import com.gal.issueTracker.model.Issue;
import com.gal.issueTracker.repo.EmployeeRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeService {
    Employee findEmployeeById(int id);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(int id);
    List<Issue> findAllIssuesByEmployeeId(int id);
    List<Issue> findAllIssuesByEmployeeIdAndByMonth(int id, int month);
    List<Issue> findAllUnresolvedIssuesByEmployeeId(int id);

}
