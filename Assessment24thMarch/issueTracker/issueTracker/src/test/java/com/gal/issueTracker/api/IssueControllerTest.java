package com.gal.issueTracker.api;

import com.gal.issueTracker.model.Employee;
import com.gal.issueTracker.service.IssueService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(IssueController.class)
class IssueControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IssueService issueService;

    @Test
    void testGetAllEmployeesWhoRaisedIssueByMonth() throws Exception {
        Employee employee = new Employee(1,"Gale");
        Employee employee2 = new Employee(2,"Chris");
        Employee employee3 = new Employee(3,"Raj");
        List<Employee> list = new ArrayList<>(List.of(employee,employee2,employee3));

        when(issueService.findAllEmployeesWhoRaisedIssueByMonth(3)).thenReturn(list);

        mockMvc.perform(get("/issue/emplWhoRaisedIssue/3")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Gale"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Chris"))
                .andExpect(jsonPath("$[2].id").value(3))
                .andExpect(jsonPath("$[2].name").value("Raj"));
    }

}