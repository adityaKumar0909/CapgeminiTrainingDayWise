package com.ak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudyService {
    @Autowired
    MessageService msr;

    public void study(){
        msr.sendMessage("Study Service is running");
    }
}
