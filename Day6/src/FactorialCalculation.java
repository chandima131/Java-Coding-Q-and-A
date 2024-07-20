public class FactorialCalculation{


    public static int factorial(int val) {
int aaa;
        if (val > 0) {
             return (val * factorial(val - 1));
        } else {
            return 1;
        }

    }
    public static void main(String args[]){
        int val = 5;

        System.out.println(factorial(val));
    }
}