public class Factorial {

    // 5! = 5*4*3*2*1 = 120

    public static int factorialValue(int val){
        int sum =1;

    for(int i=1; i <= val ; i++ ){
        sum = sum * i;
    }
        return sum;
    }

    public static void main(String args[]){

        int val =5;
        System.out.println(factorialValue(val));
    }
}
