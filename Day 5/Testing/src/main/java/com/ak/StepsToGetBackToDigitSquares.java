package com.ak;

import java.util.HashSet;

public class StepsToGetBackToDigitSquares {
    static int funct(int x){
        int temp = x;

        HashSet<Integer> hset = new HashSet<>();
        while(helper(x)!=temp){
            x = helper(x);

            if(hset.contains(temp))
            hset.add(x);

        }
    }

    private static int helper(int x) {
    }

    public static void main(){
        int count;
        count = funct(12);
        System.out.println(count);
    }
}
