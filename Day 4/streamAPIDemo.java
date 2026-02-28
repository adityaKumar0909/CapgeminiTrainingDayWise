import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamAPIDemo {
    static void main(String[] args) {

        //Concepts: Intermediate and Terminal streams

        List<Integer> list = List.of(10,20,30,40,20,50,60,90,20);
        Stream<Integer> stream=list.stream();

        boolean allMatch = stream.allMatch(x->x>40);
        System.out.println("All greater than 40 :"+allMatch);

        boolean anyStudentAbove75 = list.stream().anyMatch(x->x>75);
        System.out.println("Students above 75? : "+ anyStudentAbove75);

        System.out.println("Total no. of entries:"+list.stream().count());

        list.stream().distinct().forEach(System.out::println);

        //will only work once u tell it to either print it or collect it or count the filtered object.
        //if you don't , it wouldn't even start

        Stream<Integer> filter = list.stream().filter((x)->x>=40);
        Optional<Integer> any = filter.findAny();
        System.out.println(any);

        list.stream().filter(x->x>=40).map(x->x/10.0);

    }
}
