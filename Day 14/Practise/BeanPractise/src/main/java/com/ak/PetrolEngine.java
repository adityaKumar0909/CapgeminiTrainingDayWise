package com.ak;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
public class PetrolEngine extends Engine{

    PetrolEngine(){
        System.out.println("Petrol engine created");
    }
}
