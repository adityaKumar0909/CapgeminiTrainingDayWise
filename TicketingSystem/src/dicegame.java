import java.util.Random;
import java.util.Scanner;

public class dicegame {

    public static void main(String[] args){
        String p1,p2;
        System.out.println("Enter Player names :");
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        p1 = sc.nextLine();
        p2 = sc2.nextLine();

        System.out.println("Generating die for player 1:");
        Random r = new Random();
        int min = 1;
        int max = 6;
        int score = r.nextInt(max-min) + min;
        System.out.println(score);
        int score2 = r.nextInt(max-min) + min;
        System.out.println(score2);
        if(score>score2){
            System.out.println("Player 1 won !");
        }
        System.out.println("Player 2 won !");
    }
}
