package com.gal.issueTracker.api;

import com.gal.issueTracker.model.Employee;
import com.gal.issueTracker.model.Issue;
import com.gal.issueTracker.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Employee findEmployeeById(@RequestParam int id) {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        logger.debug("Adding employee " + employee);
        return employeeService.addEmployee(employee);
    }
    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {

        logger.debug("Updating employee " + employee);
        return employeeService.updateEmployee(employee);
    }
    @DeleteMapping
    public void deleteEmployee(@RequestParam int id) {

        logger.debug("Deleting employee " + id);
        employeeService.deleteEmployee(id);
    }
    @GetMapping("/issues/{id}")
    public List<Issue> getIssuesByEmployeeId(@PathVariable int id) {
        logger.debug("Getting issues by employee id " + id);
        return employeeService.findAllIssuesByEmployeeId(id);
    }

    @GetMapping("/unresolved/{id}")
    public List<Issue> getUnresolvedIssuesByEmployeeId(@PathVariable int id) {
        logger.debug("Getting unresolved issues by employee id " + id);
        return employeeService.findAllUnresolvedIssuesByEmployeeId(id);
    }

    @GetMapping("issues-month/{month}")
    public List<Issue> getIssuesByMonth(@PathVariable int month,@RequestParam int id) {
        logger.debug("Getting issues by month " + month);
        return employeeService.findAllIssuesByEmployeeIdAndByMonth(id,month);
    }
}
