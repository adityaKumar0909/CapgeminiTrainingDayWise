package com.ak.cabService.service;

import com.ak.cabService.entity.Cab;
import com.ak.cabService.repository.CabRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CabImplementation {

    CabRepo cabRepo;

    CabImplementation(CabRepo cabRepo){
        this.cabRepo = cabRepo;
    }

    public void addCab(Cab cab){
        cabRepo.save(cab);
    }

    public void deleteCab(Cab cab){
        cabRepo.delete(cab);
    }

    public List<Cab> getAllCabs(){
        return  cabRepo.findAll();
    }

    public Cab getCabById(long id){
        return cabRepo.findById((int) id).orElse(null);
    }

    public String getStatus(Integer id){
        Cab cab = cabRepo.findById(id).orElse(null);
        if(cab!=null){
            if(cab.getActive()){
                return "Cab is active";
            } else {
                return "Cab is not active";
            }
        }

        return "Wrong cab id given";
    }


}
