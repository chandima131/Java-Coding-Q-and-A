public class SumOfDigits {

    // int digit = 125; 1+2+5 = 8

    public static int sumOfD(int digit){

        int rem;
        int mod;
        int sum =0;

        while(digit >=1 ){
            mod = digit %10;
            rem = digit/10;
            digit = rem;
            sum +=mod;
        }
    return sum;
    }

    public static void main (String args[]){
        int digit = 0;

        System.out.println(sumOfD(digit));
    }
}
