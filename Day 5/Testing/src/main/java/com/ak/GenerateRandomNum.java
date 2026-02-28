package com.ak;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateRandomNum {

    List<Integer> GenerateRandom(){

        Random random = new Random();

        List<Integer> randomArr  = new ArrayList<>();
        for(int i=0;i<10;i++){
            randomArr.add(random.nextInt(9)+1);
        }

        return randomArr;
    }
    public static void main(String[] args){
        GenerateRandomNum gr = new GenerateRandomNum();
        List<Integer> arr = gr.GenerateRandom();

        System.out.println(arr);
    }
}
