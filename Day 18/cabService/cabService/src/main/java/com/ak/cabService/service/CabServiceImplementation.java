package com.ak.cabService.service;

import com.ak.cabService.entity.Cab;
import com.ak.cabService.entity.CabService;
import com.ak.cabService.entity.Employee;
import com.ak.cabService.repository.CabServiceRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class CabServiceImplementation {

    //Cab allot
    //If i tell a employee adn time, tell the cab allotted
    //If i enter a cab , tell if it's active or offduty

    CabServiceRepo cabServiceRepo;

    CabServiceImplementation (CabServiceRepo cabServiceRepo){
        this.cabServiceRepo = cabServiceRepo;
    }

    public void addCabService (CabService cabService) {
        cabServiceRepo.save(cabService);
    }

    public void deleteCabService (CabService cabService) {
        cabServiceRepo.delete(cabService);
    }

    public Cab getAllotedCab(Employee employee, LocalDateTime date) {
        return cabServiceRepo.getAllotedCab(employee, date);
    }


}
