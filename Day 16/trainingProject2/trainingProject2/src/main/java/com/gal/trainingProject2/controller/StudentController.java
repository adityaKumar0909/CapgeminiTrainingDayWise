package com.gal.trainingProject2.controller;

import com.gal.trainingProject2.model.Student;
import com.gal.trainingProject2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @PostMapping
    public void add(@RequestBody Student student) {
        studentService.save(student);
    }

    @PatchMapping
    public void patch(@RequestBody Student student) {
        studentService.save(student);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }


}
