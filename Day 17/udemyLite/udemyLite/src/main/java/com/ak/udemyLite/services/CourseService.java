package com.ak.udemyLite.services;

import com.ak.udemyLite.entity.Course;
import com.ak.udemyLite.repository.CourseRepo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import javax.swing.plaf.IconUIResource;
import java.util.List;

@Component
public class CourseService  {

    CourseRepo courseRepo;

    CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public Course getCourseById(Long id) {
        return courseRepo.findById(id).orElse(null);
    }

    public void addCourse(Course course) {
        courseRepo.save(course);
    }

    public void deleteCourse(Course course) {
        courseRepo.delete(course);
    }
    public void updateCourse(Course course) {
        courseRepo.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public Double getAverageRatingByCourseId(Long id) {
        return courseRepo.getAverageRatingByCourse(id);
    }











}
