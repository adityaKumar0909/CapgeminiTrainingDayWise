import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class exceptionHandling
{

    static void main(String[] args) throws Exception{

        int sum=0;
        int val;
        Scanner sc = new Scanner(System.in);


        try{for(int i=0;i<5;i++){
            try{
                val = sc.nextInt();
                sum+=val;
            }
            catch(InputMismatchException e){
                System.out.println("invalid , not a valid number");
                sc.next();
                i--;
            }



        }}
        catch (NoSuchElementException e){
            System.out.println("user denied entering input");
        }
        catch (IllegalStateException e){
            System.out.println("scanner closed");
        }
        catch (Exception e){
            System.out.println("some error occurred");
        }
        finally {
            sc.close();
        }

        System.out.println(sum);

    }
}
