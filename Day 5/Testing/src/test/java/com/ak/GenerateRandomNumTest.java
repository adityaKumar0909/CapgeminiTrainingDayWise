package com.ak;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenerateRandomNumTest {

    @Test
    void testTenNumbersOrNot(){
        int expected = 10;
        GenerateRandomNum gr = new GenerateRandomNum();
        List<Integer> actualArray = gr.GenerateRandom();
        assertEquals(expected,actualArray.size());
    }

    @Test
    void CheckIfEachDigitIsUnderTheRange(){
        GenerateRandomNum gr = new GenerateRandomNum();
        List<Integer> actualArray = gr.GenerateRandom();
//        for(int i=0;i<10;i++){
//            if(actualArray.get(i)>10 || actualArray.get(i)<1)
//                assertTrue(actualArray.get(i)>10 || actualArray.get(i)<1 ,"Number not in range");
//        }

        actualArray.forEach((x)->assertFalse((x>10 || x<1),"Not in range"));
    }



}