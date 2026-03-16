package com.ak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restro {
    Chef chef;

    public Chef getChef() {
        return chef;
    }
    @Autowired
    public void setChef(Chef chef) {
        this.chef = chef;
        System.out.println(chef + " is cooking !");
    }

    public void orderFood(){
        chef.cook();
        System.out.println("Restro served food");
    }
}
