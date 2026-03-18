package com.gal.trainingProject2.api;

import com.gal.trainingProject2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
