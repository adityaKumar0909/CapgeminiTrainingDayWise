package com.galgotias.service;

import com.galgotias.Repository.TrainingRepository;
import com.galgotias.entity.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    public List<Training> getAllOngoingAndUpcomingTrainings() {
        return trainingRepository.getOngoingAndUpcomingTrainings(LocalDate.now());
    }

    public List<Training> getOngoingAndUpcomingTrainingsByName(String name) {
        return trainingRepository.getOngoingAndUpcomingTrainingsByName(LocalDate.now(), name);
    }

    public List<Training> getUpcomingTrainingsByName(String name) {
        return trainingRepository.getUpcomingTrainingsByName(LocalDate.now(), name);
    }
}