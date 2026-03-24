package com.gal.issueTracker.api;

import com.gal.issueTracker.model.Employee;
import com.gal.issueTracker.model.Issue;
import com.gal.issueTracker.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockitoBean
    private EmployeeService employeeService;
    
    @Test
    void findAllUnresolvedIssuesByEmployeeId() throws Exception {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Aditya Kumar");
        
        Issue issue1 = new Issue();
        issue1.setId(1);
        issue1.setIssue_type("Access Permission");
        issue1.setIssue_description("Test issue 1");
        issue1.setIssue_date(Date.valueOf("2023-01-01"));
        issue1.setResolved(false);
        issue1.setEmployee(employee);
        
        Issue issue2 = new Issue();
        issue2.setId(2);
        issue2.setIssue_type("Cloud");
        issue2.setIssue_description("Test issue 2");
        issue2.setIssue_date(Date.valueOf("2023-01-02"));
        issue2.setResolved(false);
        issue2.setEmployee(employee);
        
        List<Issue> unresolvedIssues = Arrays.asList(issue1, issue2);
        
        when(employeeService.findAllUnresolvedIssuesByEmployeeId(1)).thenReturn(unresolvedIssues);
        
        mockMvc.perform(get("/employee/unresolved/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].issue_type").value("Access Permission"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].issue_type").value("Cloud"));
    }
    
    @Test
    void getIssuesByMonth() throws Exception {
        // Create mock employee
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Aditya Kumar");
        
        Issue issue1 = new Issue();
        issue1.setId(1);
        issue1.setIssue_type("Access");
        issue1.setIssue_description("Test issue 1");
        issue1.setIssue_date(Date.valueOf("2023-01-15"));
        issue1.setResolved(false);
        issue1.setEmployee(employee);
        
        Issue issue2 = new Issue();
        issue2.setId(2);
        issue2.setIssue_type("Cloud");
        issue2.setIssue_description("Test issue 2");
        issue2.setIssue_date(Date.valueOf("2023-01-20"));
        issue2.setResolved(true);
        issue2.setEmployee(employee);
        
        List<Issue> issues = Arrays.asList(issue1, issue2);
        
        when(employeeService.findAllIssuesByEmployeeIdAndByMonth(1, 1)).thenReturn(issues);
        
        mockMvc.perform(get("/employee/issues-month/1")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].issue_type").value("Access"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].issue_type").value("Cloud"));
    }




}