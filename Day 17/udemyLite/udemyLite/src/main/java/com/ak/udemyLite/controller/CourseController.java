package com.ak.udemyLite.controller;

import com.ak.udemyLite.entity.Course;
import com.ak.udemyLite.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    CourseService courseService;

    @Autowired
    CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable("id") Long id){
        return courseService.getCourseById(id);
    }

    @PostMapping
    public void addCourse(@RequestBody Course course){
        courseService.addCourse(course);
    }

    @GetMapping("/averageRating/{id}")
    public Double getAverageRating(@PathVariable("id") Long id){
        return courseService.getAverageRatingByCourseId(id);
    }



}
