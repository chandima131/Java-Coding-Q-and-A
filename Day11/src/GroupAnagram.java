import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

    //Input: strs = ["eat","tea","tan","ate","nat","bat"]
    //Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    public static List<List<String>> groupAnagram(String[] strs){

        Map <String, List<String>> map =new HashMap<>();

        for(String str : strs){
            char[] cArray = new char[26];

            for(char c : str.toCharArray()){
                cArray[c - 'a']++;
            }

            String cArrayToString = String.valueOf(cArray);

            if (!map.containsKey(cArrayToString)){
                map.put(cArrayToString, new ArrayList<>());
            }
            map.get(cArrayToString).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main (String args[]){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(groupAnagram(strs));
    }
}
