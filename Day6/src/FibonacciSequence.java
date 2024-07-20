import java.util.ArrayList;

public class FibonacciSequence {
    //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
    public static void main(String args[]){

      int x=5;

      ArrayList <Integer> arr = new ArrayList<>();
            int first =0;
            int second = 1;
            arr.add(first);
            arr.add(second);

            while (x>0) {
                int count = first + second;
                first = second;
                second = count;
                x--;
                arr.add(count);
            }

        System.out.println(arr);




    }
}
