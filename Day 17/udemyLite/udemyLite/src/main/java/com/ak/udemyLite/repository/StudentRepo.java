package com.ak.udemyLite.repository;

import com.ak.udemyLite.entity.Course;
import com.ak.udemyLite.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
}

