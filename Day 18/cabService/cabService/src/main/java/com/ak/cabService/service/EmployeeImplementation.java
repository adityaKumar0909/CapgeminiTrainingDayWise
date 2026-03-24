package com.ak.cabService.service;

import com.ak.cabService.controller.EmployeeController;
import com.ak.cabService.entity.Employee;
import com.ak.cabService.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeImplementation {
    EmployeeRepo employeeRepo;

    EmployeeImplementation(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public void addEmployee(Employee employee){
        employeeRepo.save(employee);
    }

    public void deleteEmployee(Employee employee){
        employeeRepo.delete(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findById(id);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }
}
