package com.ak.cabService.controller;

import com.ak.cabService.entity.Employee;
import com.ak.cabService.repository.EmployeeRepo;
import com.ak.cabService.service.EmployeeImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empl")
public class EmployeeController {

    EmployeeImplementation employeeImplementation;
    @Autowired
    EmployeeController(EmployeeImplementation employeeImplementation){
        this.employeeImplementation = employeeImplementation;
    }

    @PostMapping
    public void save(@RequestBody Employee employee){
        employeeImplementation.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable long id){
        return employeeImplementation.findEmployeeById(id);
    }
}
