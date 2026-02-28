import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class predicateDemo {
    static void main(String[] args) {
        //I will give u an object , u tell me true or false

        //Way 1
        Predicate<String> pred = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.endsWith("s");
            }
        };

        //Way 2
        pred  = (str)-> str.endsWith("s");
        String name = "aditys";
        System.out.println(pred.test(name));

        //Remove element if number is greater than 100
        //Way 1
        Predicate<Integer> pred1= (num)->num>100;
        List<Integer> lst = new ArrayList<>(List.of(10, 200, 30, 340, 50));
        lst.removeIf(pred1);
        System.out.println(lst);
        //Way 2
        lst.removeIf(x->x>100);
    }
}
