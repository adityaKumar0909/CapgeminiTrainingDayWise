package com.ak;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class DieselEngine extends Engine{

    DieselEngine(){
        System.out.println("Diesel engine created");
    }
}
