package com.ak;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Initialize Spring context - this enables component scanning
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ak");
        
        // Get the Car bean (which has Engine autowired)
        Car car = context.getBean(Car.class);
        
        // Now engine should be autowired
        Engine engine = car.getEngine();
        System.out.println("Engine: " + engine);
        System.out.println("Engine class: " + engine.getClass().getName());
    }
}
