package com.ak.mockitodemo.api;

import com.ak.mockitodemo.model.Training;
import com.ak.mockitodemo.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training")
public class TrainingController {
    private TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService) {
        super();
        this.trainingService = trainingService;
    }

//    @PostMapping("/add")
//    public Training addTraining(Training training) {
//        return trainingService.addTraining(training);
//    }
//
//    @PostMapping("/update")
//    public Training updateTraining(Training training) {
//        return trainingService.updateTraining(training);
//    }

    @GetMapping("/{id}")
    public Training getTrainingById(@PathVariable int id) {
        return trainingService.findById(id);
    }

//    @PostMapping("/delete")
//    public boolean deleteTraining(@RequestBody int id) {
//        return trainingService.deleteTrainingByID(id);
//    }
//
//    @GetMapping("/gettrainingbytopic/{topic}")
//    public List<Training> getTrainingByTopic(@PathVariable String topic) {
//        return trainingService.findByTopic(topic);
//    }





}
