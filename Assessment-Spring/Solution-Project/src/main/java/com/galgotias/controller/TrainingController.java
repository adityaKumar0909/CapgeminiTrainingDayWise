package com.galgotias.controller;

import com.galgotias.entity.Training;
import com.galgotias.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainings")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @GetMapping
    public List<Training> getTrainings(@RequestParam(required = false) String name) {
        if (name != null && !name.isBlank()) {
            return trainingService.getOngoingAndUpcomingTrainingsByName(name);
        }
        return trainingService.getAllOngoingAndUpcomingTrainings();
    }

    @GetMapping("/upcoming")
    public List<Training> getUpcomingTrainings(@RequestParam String name) {
        return trainingService.getUpcomingTrainingsByName(name);
    }
}