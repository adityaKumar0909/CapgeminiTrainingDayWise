package com.ak.mockitodemo.service;

import com.ak.mockitodemo.model.Training;
import com.ak.mockitodemo.repo.TrainingRepo;

import java.util.List;

public interface TrainingService {

    List<Training> findByTopic(String topic);
    Training findById(int id);
    Training addTraining(Training training);
    boolean deleteTrainingByID(int trainingID);
    Training updateTraining(Training training);



}
