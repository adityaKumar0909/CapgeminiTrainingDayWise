package com.ak.mockitodemo.impl;

import com.ak.mockitodemo.model.Training;
import com.ak.mockitodemo.service.TrainingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {

    @Override
    public List<Training> findByTopic(String topic) {
        return List.of();
    }

    @Override
    public Training findById(int id) {
        return null;
    }

    @Override
    public Training addTraining(Training training) {
        return null;
    }

    @Override
    public boolean deleteTrainingByID(int trainingID) {
        return false;
    }

    @Override
    public Training updateTraining(Training training) {
        return null;
    }
}
