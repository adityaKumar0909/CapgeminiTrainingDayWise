package com.ak;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BubbleSort {

    static void BubbleSort(List<Integer> arr){

        int size = arr.size();
        for(int i=0;i<size-1;i++){
            boolean swapped =  false;
            for(int j=0;j<size-1-i;j++){
                if(arr.get(j)>arr.get(j+1))
                Collections.swap(arr,j,j+1);
            }
        }

        System.out.println(arr);

    }

    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>(List.of(10,43,52,85,14,15));
        BubbleSort(arr);

    }
}
