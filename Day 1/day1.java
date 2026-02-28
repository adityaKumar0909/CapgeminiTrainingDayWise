import java.util.*;
class day1{
    public static void main(String[] args) {
        int rollNumber;
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter roll no:");
        rollNumber = sc.nextInt();
        System.out.println("Enter name:");
        name = sc.nextLine();
        System.out.println("Hello "+name+" , you roll no is :"+rollNumber);

    }
}