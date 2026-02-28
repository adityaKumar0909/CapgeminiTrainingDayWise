import java.sql.SQLOutput;
import java.util.*;

void main(String[] args) throws IOException {
//    FileInputStream fin = new FileInputStream("data.txt");
//    FileOutputStream fout = new FileOutputStream("dataCopy.txt");
//
//    int ch;
//    while((ch=fin.read())!=-1){
//        ch = fin.read();
//        fout.write(ch);
//    }
//
//    fin.close();
//    fout.close();
//    System.out.println("file copied");
//    Scanner sc = new Scanner(System.in);
//    FileInputStream fin = new FileInputStream("data.txt");
//    BufferedInputStream bis = new BufferedInputStream(fin);
//    InputStreamReader isr = new InputStreamReader(bis);
//
//    FileOutputStream fout=new FileOutputStream("dataCopy.txt");
//    String str;
    //To print one char at a time
//    FileInputStream fin = new FileInputStream("z.txt");
//    FileOutputStream fout = new FileOutputStream("zCopy.txt");
//
//    int ch=0;
//    boolean skip=false;
//    while(ch  != -1){
//        ch = fin.read();
//        if(ch==-1){
//            break;
//        }
//        if(skip)
//            fout.write(ch);
//        skip=!skip;
//    }
    //To print one word at a time
//    try (BufferedReader br = new BufferedReader(new FileReader("data.txt"));
//         BufferedWriter bw = new BufferedWriter(new FileWriter("dataCopy.txt"))) {
//
//        String line;
//        boolean toggle = true;
//        while ((line = br.readLine()) != null) {
//
//            String processedLine = line;
//            if(toggle) {
//                bw.write(processedLine);
//                bw.newLine();
//            }
//            toggle = !toggle;
//        }
//
//        System.out.println("File copied and processed successfully!");
//
//    } catch (IOException e) {
//        System.err.println("An error occurred: " + e.getMessage());
//    }

    //To print alternate words
    try (BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("dataCopy.txt"));) {
        String line;
        boolean copy = true;
        while ((line = br.readLine()) != null) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (copy) {
                    bw.write(word + " ");
                }
                copy = !copy;
            }
            bw.newLine();
        }
    }catch (IOException e){
        System.out.println(e);
    }



}