package com.ak.udemyLite.controller;

import com.ak.udemyLite.entity.Enrollment;
import com.ak.udemyLite.entity.Student;
import com.ak.udemyLite.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService){
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public void saveEnrollment(@RequestBody Enrollment enrollment){
        enrollmentService.addEnrollment(enrollment);
    }

    @GetMapping
    public List<Enrollment> getAllEnrollments(){
        return enrollmentService.findAllEnrollments();
    }



}
