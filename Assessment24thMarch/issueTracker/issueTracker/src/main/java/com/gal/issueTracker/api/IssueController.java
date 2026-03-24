package com.gal.issueTracker.api;

import com.gal.issueTracker.model.Employee;
import com.gal.issueTracker.model.Issue;
import com.gal.issueTracker.service.IssueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issue")
public class IssueController {
    private static final Logger logger = LoggerFactory.getLogger(IssueController.class);

    IssueService issueService;
    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @PostMapping
    public Issue addIssue(@RequestBody Issue issue) {
        logger.debug("Adding issue " + issue);
        return issueService.addIssue(issue);
    }
    @DeleteMapping("/{id}")
    public void deleteIssue(@PathVariable int id) {

        logger.debug("Deleting issue " + id);
        issueService.deleteIssueById(id);
    }

    @GetMapping("emplWhoRaisedIssue/{month}")
    public List<Employee> getAllEmployeesWhoRaisedIssueByMonth(@PathVariable int month) {
        logger.debug("Getting all employees who raised issue " + month);
        return issueService.findAllEmployeesWhoRaisedIssueByMonth(month);
    }
}
