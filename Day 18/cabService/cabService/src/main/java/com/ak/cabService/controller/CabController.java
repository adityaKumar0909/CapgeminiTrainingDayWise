package com.ak.cabService.controller;

import com.ak.cabService.entity.Cab;
import com.ak.cabService.exception.CabNotFoundException;
import com.ak.cabService.service.CabImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cab")
public class CabController {

    CabImplementation cabImplementation;

    public CabController(CabImplementation cabImplementation){
        this.cabImplementation = cabImplementation;
    }

    @PostMapping
    public void addNewCab(@RequestBody Cab cab){
        cabImplementation.addCab(cab);
    }

    @GetMapping("/{id}")
    public Cab getCabById(@PathVariable Long id){
        return cabImplementation.getCabById(Math.toIntExact(id));
    }

    @GetMapping("/isActive/{id}")
    public String isActiveCabById(@PathVariable Long id){
        return cabImplementation.getStatus(Math.toIntExact(id));
    }

    @ExceptionHandler(CabNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCabNotFound(CabNotFoundException e) {
        ErrorResponse error = new ErrorResponse(404, e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


}
