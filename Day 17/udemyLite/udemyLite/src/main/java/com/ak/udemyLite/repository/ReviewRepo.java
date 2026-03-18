package com.ak.udemyLite.repository;

import com.ak.udemyLite.entity.Course;
import com.ak.udemyLite.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review,Long> {


}
