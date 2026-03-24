package com.ak.cabService.repository;

import com.ak.cabService.entity.Cab;
import com.ak.cabService.entity.CabService;
import com.ak.cabService.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface CabServiceRepo extends JpaRepository<CabService,Integer> {

    @Query("SELECT cs.cab from CabService cs where cs.employee =:emp and cs.pickupDate =:date")
    public Cab getAllotedCab(Employee emp, LocalDateTime date);
}
