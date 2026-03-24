package com.ak.mockitodemo.api;

import com.ak.mockitodemo.model.Training;
import com.ak.mockitodemo.service.TrainingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TrainingController.class)
class TrainingControllerTest {

    @MockitoBean
    TrainingService trainingService;
    @Autowired
    MockMvc mockMvc;

    @Test
    void testFindById() throws Exception {
        Training t = new Training(
                101,
                Date.valueOf("2026-03-07"),
                Date.valueOf("2026-05-07"),
                "Mockito",
                "Mr. Dinesh Kumar"
        );

        when(trainingService.findById(101)).thenReturn(t);
//        when(trainingService.findById(101)).thenThrow(new RuntimeException("Training not found"));

        mockMvc.perform(get("/training/101").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("101"));

    }


}