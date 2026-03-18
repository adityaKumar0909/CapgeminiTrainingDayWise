package com.ak.udemyLite.services;

import com.ak.udemyLite.entity.Course;
import com.ak.udemyLite.entity.Enrollment;
import com.ak.udemyLite.repository.EnrollmentRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnrollmentService {

    EnrollmentRepo enrollmentRepo;

    EnrollmentService(EnrollmentRepo enrollmentRepo) {
        this.enrollmentRepo = enrollmentRepo;
    }

    public Enrollment getEnrollmentById(Long enrollmentId) {
        return enrollmentRepo.findById(enrollmentId).orElse(null);
    }

    public void  addEnrollment(Enrollment enrollment) {
        enrollmentRepo.save(enrollment);
    }

    public void deleteById(Long enrollmentId) {
        enrollmentRepo.deleteById(enrollmentId);
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepo.findAll();
    }

    public void updateById(Enrollment enrollment) {
        enrollmentRepo.save(enrollment);
    }

    public List<Enrollment> findAllEnrollments() {
        return enrollmentRepo.findAll();
    }

    public List<Course> getAllCourseByEnrollmentId(Long enrollmentId) {
        return enrollmentRepo.getAllCoursesOfStudent(enrollmentId);
    }





}
