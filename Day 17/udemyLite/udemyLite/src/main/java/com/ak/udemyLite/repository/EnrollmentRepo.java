package com.ak.udemyLite.repository;

import com.ak.udemyLite.entity.Course;
import com.ak.udemyLite.entity.Enrollment;
import com.ak.udemyLite.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment,Long> {

     @Query( "SELECT e.course from Enrollment e WHERE e.student.id =:id")
     List<Course> getAllCoursesOfStudent(Long id);



}
