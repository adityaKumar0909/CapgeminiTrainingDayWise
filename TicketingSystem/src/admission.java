import java.util.ArrayList;
import java.util.Scanner;

//add , update, delete
public class admission {
    static ArrayList<String> studentNames = new ArrayList<>();

    public static void main(String[] args){
        boolean isRunning = true;
        while(isRunning){
           isRunning =  Menu1();
        };
    }

    private static boolean Menu1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would u like to do ?");
        System.out.println("(1) Add Student");
        System.out.println("(2) Update Student");
        System.out.println("(3) Delete Record");
        System.out.println("(4) View all Record");
        System.out.println("(5) Quit");


        int option = sc.nextInt();
        switch (option){
            case 1:{
                AddStudent();
            }
            break;
            case 2:{
                UpdateData();
            }
            break;
            case 3:{
                DeleteRecord();

            }
            case 4:{
               viewAllStudent();
            }
            break;
            case 5:{
                return false;
            }
            default:{
                System.out.println("invalid option");
            }


        }
        return true;

    }

    static void DeleteRecord() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter index :");
        int index =sc.nextInt();
        studentNames.remove(index);
        System.out.println("Name removed");
        Menu1();
    }

    static void UpdateData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter index :");
        int index =sc.nextInt();
        if(index>studentNames.size()){
            System.out.println("invalid size");
            return;
        }
        System.out.println("Enter new name:");
        String newName = sc.nextLine();
        studentNames.set(index, newName);
        System.out.println("Name updated successfully");
        Menu1();

    }

    static void AddStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name :");
        String name = sc.nextLine();
        studentNames.add(name);
        System.out.println("Student Added");
        System.out.println("------------");
        Menu1();
    }
    static void viewAllStudent(){
        for(String str:studentNames){
            System.out.println(str);
        }
    }


}
