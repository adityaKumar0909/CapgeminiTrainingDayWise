package com.gal.issueTracker.implementation;

import com.gal.issueTracker.model.Employee;
import com.gal.issueTracker.model.Issue;
import com.gal.issueTracker.repo.EmployeeRepo;
import com.gal.issueTracker.service.EmployeeService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeImpl implements EmployeeService {

    EmployeeRepo employeeRepo;
    public EmployeeImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee findEmployeeById(int id) {
        return employeeRepo.findById(id).orElse(null);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public List<Issue> findAllIssuesByEmployeeId(int id) {
        return employeeRepo.findAllIssuesByEmployeeId(id);
    }

    @Override
    public List<Issue> findAllIssuesByEmployeeIdAndByMonth(int id, int month) {
        return employeeRepo.findAllIssuesByEmployeeIdAndByMonth(id, month);
    }

    @Override
    public List<Issue> findAllUnresolvedIssuesByEmployeeId(int id) {
        return employeeRepo.findAllUnresolvedIssuesByEmployeeId(id);
    }
}
