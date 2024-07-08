import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    String file = "data.txt";

        Map<String, List<Integer>> studentScore = new HashMap<>();

    try(BufferedReader br = new BufferedReader(new FileReader(file))){

        String line;

        while((line = br.readLine()) != null){

            String[] parts = line.split(", ");

            String name = parts[0];
            int score = Integer.parseInt(parts[2]);

            if(!studentScore.containsKey(name)){
                studentScore.put(name,new ArrayList<>());
            }
            studentScore.get(name).add(score);
        }

    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    for (Map.Entry<String, List<Integer>> entry : studentScore.entrySet()){
        System.out.println(entry.getKey() +"is" + entry.getValue());
    }
    // find max in list

        Map <String,Integer> maxScore = new HashMap<>();

        for (Map.Entry<String, List<Integer>> entry : studentScore.entrySet()){
            int max=0;

            List <Integer> vals = entry.getValue();
            //System.out.println(scores);

            for(int val : vals){

                if(val > max){
                    max = val;
                }
            }


            maxScore.put(entry.getKey(),max);

            System.out.println(entry.getKey() +"is " +max);


        }

    }
}