import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class randomAccessFile {
    static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("data.txt", "r");
        long len = raf.length();

        if(len>=2){
            raf.seek(len-2);
            int byte1 = raf.read();
            int byte2 = raf.read();
            System.out.println("Byte1: "+byte1+" Byte2: "+byte2);
        }
        else{
            System.out.println("File has less than two bytes");
        }


    }
}
