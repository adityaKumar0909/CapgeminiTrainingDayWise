package com.ak;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarFactory {
    @Bean
    public Car car(){
        return new Car();
    }
}
