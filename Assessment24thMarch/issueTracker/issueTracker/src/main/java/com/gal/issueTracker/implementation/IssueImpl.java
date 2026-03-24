package com.gal.issueTracker.implementation;

import com.gal.issueTracker.model.Employee;
import com.gal.issueTracker.model.Issue;
import com.gal.issueTracker.repo.IssueRepo;
import com.gal.issueTracker.service.IssueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueImpl implements IssueService {

    IssueRepo issueRepo;

    public IssueImpl(IssueRepo issueRepo) {
        this.issueRepo = issueRepo;
    }
    @Override
    public Issue findIssueById(int id) {
        return issueRepo.findById(id).orElse(null);
    }


    @Override
    public Issue addIssue(Issue issue) {
        return issueRepo.save(issue);
    }

    @Override
    public Issue updateIssue(Issue issue) {
        return issueRepo.save(issue);
    }

    @Override
    public void deleteIssueById(int id) {
        issueRepo.deleteById(id);
    }
    @Override
    public List<Employee> findAllEmployeesWhoRaisedIssueByMonth(int month) {
        return issueRepo.findAllEmployeesWhoRaisedIssueByMonth(month);
    }
}
