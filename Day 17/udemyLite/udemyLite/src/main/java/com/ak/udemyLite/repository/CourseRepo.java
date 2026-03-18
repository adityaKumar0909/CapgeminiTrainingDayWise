package com.ak.udemyLite.repository;

import com.ak.udemyLite.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course,Long> {
    @Query("SELECT AVG(r.rating) from Review r where r.course =:id")
    Double getAverageRatingByCourse(Long id);


}
