import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Add{

    int sum(int a, int b);

}

public class lambdaFunction {
    //In Java Lambda expressions is equivalent to Objects


    static void main(String[] args) {




        //An interfac having a single function
        Add sum3 = new Add() {
            @Override
            public int sum(int a, int b) {
                return a+b;
            }
        };

        //Another way of showing writing it.
        Add sum2 = (int a, int b)->a+b;

        //The simplest way of writing it
        Add sum = (a,b)->a+b;


        int idk = sum.sum(100,40);
//        System.out.println(idk);
        
        List<String> lst = new ArrayList<>();
        lst.add("Aditya");
        lst.add("Mukul");
        lst.add("Abdul");
        lst.add("Ayush");


        lst.sort((e1,e2)->e1.compareTo(e2));
        System.out.println(lst);


    }
}



