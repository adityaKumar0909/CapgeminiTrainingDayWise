package com.ak.udemyLite.services;

import com.ak.udemyLite.entity.Course;
import com.ak.udemyLite.entity.Student;
import com.ak.udemyLite.repository.EnrollmentRepo;
import com.ak.udemyLite.repository.StudentRepo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {

    StudentRepo studentRepo;
    EnrollmentRepo enrollmentRepo;

    StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
        this.enrollmentRepo = enrollmentRepo;
    }

    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    public void addStudent(Student student) {
        studentRepo.save(student);
    }

    public void deleteStudentById(Long id) {
        studentRepo.deleteById(id);
    }
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public void updateStudent(Student student) {
        studentRepo.save(student);
    }

    public List<Course> getAllCoursesOfStudent(Long id) {
        return enrollmentRepo.getAllCoursesOfStudent(id);
    }


}
