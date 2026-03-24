package com.gal.issueTracker.repo;

import com.gal.issueTracker.model.Employee;
import com.gal.issueTracker.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
     @Query("SELECT distinct i from Issue i where i.employee.id =:id")
     List<Issue> findAllIssuesByEmployeeId(int id);
    @Query("SELECT distinct i from Issue i where i.employee.id =:id AND MONTH(i.issue_date) =:month")
    List<Issue> findAllIssuesByEmployeeIdAndByMonth(int id, int month);
    @Query("select distinct i from Issue i where i.employee.id=:id AND i.isResolved=false")
     List<Issue> findAllUnresolvedIssuesByEmployeeId(int id);
}
