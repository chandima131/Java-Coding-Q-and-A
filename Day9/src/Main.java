import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        char[] array = new char[100];
        try {

            FileReader fr = new FileReader("text.txt");
            BufferedReader br = new BufferedReader(fr);


            System.out.println(  br.read(array));


        } catch (Exception e){
            e.getStackTrace();
        }


    }
}