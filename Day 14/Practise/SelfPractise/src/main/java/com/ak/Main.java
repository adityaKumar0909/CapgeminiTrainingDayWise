package com.ak;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
             ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        Restro restaurant = context.getBean( Restro.class);

        restaurant.orderFood();
    }
}
