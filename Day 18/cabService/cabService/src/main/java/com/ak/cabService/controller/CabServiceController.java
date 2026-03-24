package com.ak.cabService.controller;

import com.ak.cabService.entity.Cab;
import com.ak.cabService.entity.CabService;
import com.ak.cabService.entity.Employee;
import com.ak.cabService.service.CabServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/cabservice")
public class CabServiceController {

    CabServiceImplementation cabServiceImplementation;
    @Autowired
    public CabServiceController(CabServiceImplementation cabServiceImplementation){
        this.cabServiceImplementation = cabServiceImplementation;
    }

    @GetMapping("/getCab/")
    public Cab getCab(@RequestBody Employee emp, @RequestBody LocalDateTime date){
        return cabServiceImplementation.getAllotedCab(emp, date);
    }

    @PostMapping
    public void addCabService(@RequestBody CabService cabService) {
        cabServiceImplementation.addCabService(cabService);
    }
}
