package com.ak;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 @Configuration
public class BeanConfig {

     @Bean
     public Student getStudent(){
         return new Student();
     }

}
