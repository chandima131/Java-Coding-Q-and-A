public class StringToInteger {

    //String = "123" -> 123

    public static int stringToInt(String s){

        return Integer.parseInt(s);
    }

    public static void main(String args[]){
        String s = "123";

        System.out.println(stringToInt(s));
    }
}
