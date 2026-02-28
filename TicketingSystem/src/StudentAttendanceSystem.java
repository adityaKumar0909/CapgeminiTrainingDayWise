import java.util.*;

public class StudentAttendanceSystem {


    static class Student {
        String name;
        String loginTime;
        String logoutTime;
        List<Integer> marks = new ArrayList<>();
        int totalMarks;
        double totalPercentage;
        long pass;
        boolean isLoggedIn = false;
    }

    static List<Student> totalStudents = new ArrayList<>();

    public static void main(String[] args) {

        Menu();

    }

    static void Menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Menu :");
        System.out.println("(1) Create new student credential");
        System.out.println("(2) Login");
        System.out.println("(3) Quit");
//        System.out.println("(3) Logout");
//        System.out.println("(4) Read PDF");
//        System.out.println("(5) Show Marks");
//        System.out.println("(6) Show Final Result");


        System.out.println("Enter option:");
        int option = sc.nextInt();
        System.out.println("-------------------");
        switch (option) {
            case 1: {
                CreateNewLogin();
                Menu();
            }
            break;
            case 2: {
                Login();
                Menu();
            }
            break;
            case 3: {
                return;
            }
            default: {
                System.out.println("Invalid option");
                Menu();
            }
        }
    }

    private static void ShowFinalScore(Student st) {
        int sum = 0;
        int totalSubjects = st.marks.size();
        for(int x:st.marks){
            sum+=x;
        }
        double percentage = ((double)sum/500)*100;
        System.out.println("Overall percentage: "+percentage);
        System.out.println("=========================");




    }

    private static void ShowMarks(Student st) {
        Random r = new Random();
        int low = 1;
        int high = 100;

        for (int i = 0; i < 5; i++) {
            st.marks.add(r.nextInt(high-low)+low);
        }
        System.out.println("Marks received in Science , Maths , English ,Python, Java ");

        for(int x:st.marks){
            System.out.println(x);
        }
        System.out.println("----------------------------------------------");


    }

    private static void ReadPDF() {
        System.out.println("PDF opened !");
    }

    private static void Logout(Student st) {

        st.isLoggedIn = false;
        System.out.println("Logged out successfully");

        System.out.println("Wrong credentials");
    }

    private static void Login() {
        System.out.println("Enter Name :");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Enter password :");
        long password = sc.nextLong();
        for (Student st : totalStudents) {
            if (Objects.equals(st.name, name) && st.pass == password) {
                st.isLoggedIn = true;
                System.out.println("Logged  in successfully");
                Menu2(st);

            }
        }

        System.out.println("Wrong credentials");
    }

    private static void Menu2(Student st) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hello " + st.name);
        System.out.println("(1)Read PDF");
        System.out.println("(2)Show Marks");
        System.out.println("(3)Show Final Result");
        System.out.println("(4)Log out");


        System.out.println("Enter option:");
        int option = sc.nextInt();
        System.out.println("-------------------");
        switch (option) {
            case 1: {
                ReadPDF();
                Menu2(st);
            }
            break;
            case 2: {
                ShowMarks(st);
                Menu2(st);
            }
            break;
            case 3: {
                ShowFinalScore(st);
                Menu2(st);
            }
            case 4: {
                Logout(st);
                Menu();
            }
            default: {
                System.out.println("Invalid option");
                Menu();
            }
        }


    }

    private static void CreateNewLogin() {
        System.out.println("Enter Name :");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Enter password :");
        long password = sc.nextLong();

        Student newStudent = new Student();
        newStudent.name = name;
        newStudent.pass = password;
        totalStudents.add(newStudent);
        System.out.println("Credential Created!");

    }


}