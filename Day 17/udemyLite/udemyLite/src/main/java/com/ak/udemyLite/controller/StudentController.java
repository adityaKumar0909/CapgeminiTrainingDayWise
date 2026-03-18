package com.ak.udemyLite.controller;

import com.ak.udemyLite.entity.Course;
import com.ak.udemyLite.entity.Student;
import com.ak.udemyLite.repository.StudentRepo;
import com.ak.udemyLite.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PatchMapping
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@RequestBody Student student, @PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

    @GetMapping("/getcourse/{id}")
    public List<Course> getAllCoursesOfStudent(@PathVariable Long id) {
        return studentService.getAllCoursesOfStudent(id);
    }


}
