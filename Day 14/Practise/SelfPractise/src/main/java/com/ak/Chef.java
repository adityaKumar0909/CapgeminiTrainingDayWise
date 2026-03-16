package com.ak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Chef {

    Food food;

    public void cook(){
        System.out.println("Chef is cooking "+food+" ...");
    }

    public Food getFood() {
        return food;
    }
    @Autowired
    public void setFood(Food food) {
        this.food = food;
        System.out.println(food +" is set");
    }
}
