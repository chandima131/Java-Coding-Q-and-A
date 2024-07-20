public class PalindromeChecker {

    //string is a palindrome

    public static boolean checkPalindrome(String str){

 // using string builder

        StringBuilder sb =new StringBuilder();
        String reverse = sb.append(str).reverse().toString();

        if(str.equals(reverse)){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String args[]){
        String str = "abb";
        System.out.println(checkPalindrome(str));
    }
}
