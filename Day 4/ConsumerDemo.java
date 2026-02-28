import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumerDemo {


    static void main(String[] args) {

        //Give some value to it and it will return value
        List<Integer> lst = List.of(12,23,34,45,63,23);
        //Way 1
        lst.forEach((x)-> System.out.println("consuming 1 : "+x));
        //Way 2
        lst.forEach(System.out::println);
        //Way 3
        lst.forEach(new Consumer<Integer>(){
            @Override
            public void accept(Integer x){
                System.out.println("consuming 3 :"+x);
            }
        });
        //Write  a lambda function to convert the first two chars to uppercase
        Function<String,String> funct = (str)-> str.substring(0,2).toUpperCase() + str.substring(2);
        String str = "aditya";
        System.out.println( funct.apply(str));
    }
}
