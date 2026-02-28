import java.io.*;

public class demoEducationTrainer {
    public static void main(String[] args)  {
//        Reader reader = new Reader();// this class object cannot be created
        InputStream input  = System.in;
        InputStreamReader is = new InputStreamReader(input);
        BufferedReader bf = new BufferedReader(is);

        try {
            FileReader fileReader =  new FileReader("Hello");
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
//        bf.readLine();

    }
}
