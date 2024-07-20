public class Palindarom {

    public static boolean isPalindarome(String str){
        char[] reverse = new char[str.length()];

        StringBuilder sb = new StringBuilder();
        if(str.isEmpty()){
            return false;
        } else {
            for(int i= str.length()-1 ; i >= 0; i--){
                sb.append(str.charAt(i));
            }
            return str.equals(sb.toString());
        }
    }

    public static void main (String args[]){
         String str = "121";

        System.out.println(isPalindarome(str));
    }

}
