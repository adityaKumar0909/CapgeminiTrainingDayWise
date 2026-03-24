package com.ak.cabService.controller;

import com.ak.cabService.entity.Cab;
import com.ak.cabService.exception.CabNotFoundException;
import com.ak.cabService.service.CabImplementation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.http.MediaType;



@WebMvcTest(CabController.class)
class CabControllerTest {



    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    private CabImplementation cabImplementation;

    @Test
    void testGetCab() throws Exception {
        Cab cab = new Cab(
                1,
                "Swift",
                "Mahesh",
                true
        );

        when(cabImplementation.getCabById(1)).thenReturn(cab).thenThrow(new CabNotFoundException("Cab not found"));

        mockMvc.perform(get("/cab/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Swift"));

        mockMvc.perform(get("/cab/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").exists())
                .andExpect(jsonPath("$.message").exists());
    }


}