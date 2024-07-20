import java.util.Stack;

public class LongestCommonPrefix {

    //strs = ["flower","flow","flight"]

    public static String longestPrefix(String[] str){

        if(str.length == 0) return " ";

        String prefix = str[0];
    for(int i =1; i< str.length ;i++){

        while (str[i].indexOf(prefix) !=0){
            prefix = prefix.substring(0, prefix.length()-1);
        }
    }
    return prefix.isEmpty() ? "no value" : prefix;
    }

    public static void main (String args[]){
       String[] strs = {"dog","racecar","car"};

        System.out.println(longestPrefix(strs));
    }
}
