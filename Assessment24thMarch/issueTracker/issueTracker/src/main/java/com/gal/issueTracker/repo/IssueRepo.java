package com.gal.issueTracker.repo;

import com.gal.issueTracker.model.Employee;
import com.gal.issueTracker.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepo extends JpaRepository<Issue,Integer> {

    @Query("SELECT distinct i.employee from Issue i where MONTH(i.issue_date) =:month")
    List<Employee> findAllEmployeesWhoRaisedIssueByMonth(int month);

}
