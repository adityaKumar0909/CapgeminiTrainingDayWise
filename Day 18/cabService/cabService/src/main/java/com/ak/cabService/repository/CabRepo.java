package com.ak.cabService.repository;

import com.ak.cabService.entity.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabRepo extends JpaRepository<Cab,Integer> {
}
