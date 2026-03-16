package com.ak;


import org.springframework.stereotype.Component;

@Component
public class MessageService {

     public void sendMessage(String msg) {
        System.out.println("Reminder: " + msg);
    }
}
