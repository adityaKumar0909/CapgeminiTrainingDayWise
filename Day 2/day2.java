import java.io.*;
import java.util.*;

public class day2 {

    static HashMap<Integer, Student> records = new HashMap<>();

    static void main(String[] args) throws IOException, ClassNotFoundException {
        Menu();
    }

    private static void Menu() throws IOException, ClassNotFoundException {
        System.out.println("--------Menu------");
        System.out.println("(1) Search Marks by roll no.");
        System.out.println("(2) Enter new student records");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        if(option == 1){
            searchMarks();
        }
        else if(option==2){
            createNewObject();
        }
        else if(option==-1){
            return;
        }
        else{
            System.out.println("invalid option");
            Menu();
        }
    }

    private static void createNewObject() throws IOException, ClassNotFoundException {
        Student st = new Student();
        System.out.println("enter name ");
        Scanner sc = new Scanner(System.in);
        st.name = sc.next();
        System.out.println("enter roll no:");
        st.rollNo = sc.nextInt();
        System.out.println("enter marks:");
        int val = sc.nextInt();
        st.marks = val;
        records.put(st.rollNo, st);


        FileOutputStream fout = new FileOutputStream("allRecords.txt");
        ObjectOutputStream obout = new ObjectOutputStream(fout);
        obout.writeObject(records);
        obout.close();
        fout.close();
        Menu();
    }

    private static void searchMarks() throws IOException, ClassNotFoundException {
        System.out.println("enter roll no:");
        Scanner sc = new Scanner(System.in);
        int roll = sc.nextInt();
        FileInputStream fin = new FileInputStream("allRecords.txt");
        ObjectInputStream obin = new ObjectInputStream(fin);
        @SuppressWarnings("unchecked")
        HashMap<Integer,Student> records = (HashMap<Integer,Student>)obin.readObject();
        if(records.containsKey(roll)){
            System.out.println("Marks : "+records.get(roll).marks);
            System.out.println("done");
        }
        else{
            System.out.println("not found");
        }

        Menu();
    }
}


