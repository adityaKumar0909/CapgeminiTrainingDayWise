package com.gal.trainingProject2.service;

import com.gal.trainingProject2.api.StudentRepository;
import com.gal.trainingProject2.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

   private final StudentRepository studentRepo;

    @Autowired
    public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student findById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    public void save(Student student) {
        studentRepo.save(student);
    }

    public void delete(long id) {
        studentRepo.deleteById(id);
    }

    public void updateById(Student student) {
        studentRepo.save(student);
    }


}
