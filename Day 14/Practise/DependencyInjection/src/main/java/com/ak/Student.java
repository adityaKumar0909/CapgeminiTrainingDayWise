package com.ak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Student {

    StudyService studyService;

    public void whatToMakeStudentDo(){
        System.out.println("Student started studying");
    }


}
