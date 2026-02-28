import java.util.*;
public class dayOne {

    public static void main(String[] args){
        ArrayList<String> food = new ArrayList<>();
        //Add
        food.add("Dosa Sambhar");
        // Add all
        ArrayList<String> food2 = new ArrayList<>();
        food2.add("imli");
        food2.add("aam");
        food.addAll(food2);
        //clear
        food2.clear();
        //contains
        food.contains("Dosa Sambhar");
        //contailsAll
        food2.containsAll(food);
        //remove
        food.remove("Imli");
        //removeAll
        food.removeAll(food2);
        //size
        food.add("Khatta aam");
        food.add("Coca cola");
        food.size();
        food2.add("Khatta Aam");
        //retainAll
        food.retainAll(food2);
        //isEmpty();
        System.out.println(food.isEmpty());
        //iteration
        for(String str: food){
            System.out.println(str);
        }
        //stream
        food.stream();


        food.remove("Dosa Sambhar");
        System.out.println(food.size());


    }
}
